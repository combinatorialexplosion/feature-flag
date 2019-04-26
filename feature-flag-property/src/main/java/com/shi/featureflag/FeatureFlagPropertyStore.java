package com.shi.featureflag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FeatureFlagPropertyStore implements FeatureFlagStore
{
	private Properties			properties		= new Properties();
	boolean							cachingEnabled	= false;
	Map<String, FeatureFlag>	featureMapping	= new HashMap<>();

	FeatureFlagPropertyStore()
	{
	}

	FeatureFlagPropertyStore(File f) throws FileNotFoundException, IOException
	{
		properties.load(new FileInputStream(f));
	}

	FeatureFlagPropertyStore(File f, boolean cachingEnabled) throws FileNotFoundException, IOException
	{
		properties.load(new FileInputStream(f));
		this.cachingEnabled = cachingEnabled;
	}

	FeatureFlagPropertyStore(Properties properties)
	{
		this.properties = properties;
	}

	@Override
	public FeatureFlag get(String name)
	{
		if (cachingEnabled && featureMapping.containsKey(name))
		{
			return featureMapping.get(name);
		}

		String flag = properties.getProperty(name);

		if (flag == null)
		{
			return new FeatureFlag(name);
		}

		FeatureFlag f = new FeatureFlag(name, true);

		if (cachingEnabled)
		{
			featureMapping.put(name, f);
		}

		return f;
	}

	@Override
	public Collection<FeatureFlag> getAll()
	{
		return featureMapping.values();
	}

	@Override
	public void put(FeatureFlag ff)
	{
		featureMapping.put(ff.getName(), ff);
	}

}