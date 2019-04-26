package com.shi.featureflag;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.shi.featureflag.exceptions.NotFoundException;

public class FeatureFlagBaseStore implements FeatureFlagStore
{
	private Map<String, FeatureFlag> store = new HashMap<>();

	@Override
	public FeatureFlag get(String name) throws NotFoundException
	{
		if (store.containsKey(name))
		{
			throw new NotFoundException();
		}

		return store.get(name);
	}

	@Override
	public Collection<FeatureFlag> getAll()
	{
		return store.values();
	}

	protected Map<String, FeatureFlag> getStore()
	{
		return store;
	}

	@Override
	public void put(FeatureFlag ff)
	{
		store.put(ff.getName(), ff);
	}
}