package com.shi.featureflag;

import java.util.Collection;

import com.shi.featureflag.exceptions.NotFoundException;

public interface FeatureFlagStore
{
	FeatureFlag get(String name) throws NotFoundException;

	Collection<FeatureFlag> getAll();

	void put(FeatureFlag ff);
}