package com.shi.featureflag;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.shi.featureflag.exceptions.NotFoundException;

@Service
public class FeatureFlagStoreService extends FeatureFlagBaseStore implements FeatureFlagStore
{
	@Cacheable
	@Override
	public FeatureFlag get(String name) throws NotFoundException
	{
		return getStore().get(name);
	}
}