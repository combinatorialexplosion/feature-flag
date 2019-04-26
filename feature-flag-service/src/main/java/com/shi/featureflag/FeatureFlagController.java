package com.shi.featureflag;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shi.featureflag.exceptions.NotFoundException;

@RestController
public class FeatureFlagController
{
	@Autowired
	FeatureFlagStoreService featureFlagStoreService;

	/**
	 * Adds a feature flag to the feature flag store
	 *
	 * @param flag
	 *           - FeatureFlag to add to store
	 */
	@PostMapping(path = "/v1/feature", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestParam FeatureFlag featureFlag)
	{
		featureFlagStoreService.put(featureFlag);
	}

	/**
	 * Get the feature flag with the provided name
	 *
	 * @param name
	 *           - name of feature
	 * @return - FeatureFlag
	 * @throws NotFoundException
	 */
	@GetMapping(path = "/v1/feature/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public FeatureFlag get(@PathParam("name") String name) throws NotFoundException
	{
		return featureFlagStoreService.get(name);
	}

	@GetMapping(path = "v1/features")
	public Collection<FeatureFlag> getAllFeatures()
	{
		return featureFlagStoreService.getAll();
	}

	/**
	 * Toggles the feature if it exists. If the feature does not exists, throws an
	 * exception
	 *
	 * @param name
	 * @throws NotFoundException
	 */
	@GetMapping(path = "v1/feature/{name}/toggle", produces = MediaType.APPLICATION_JSON_VALUE)
	public void toggle(@PathParam("name") String name) throws NotFoundException
	{
		FeatureFlag ff = featureFlagStoreService.get(name);
		ff.setEnabled(!ff.isEnabled());
	}
}