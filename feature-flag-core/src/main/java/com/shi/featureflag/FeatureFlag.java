package com.shi.featureflag;

public class FeatureFlag
{
	private String		name		= "";
	private boolean	enabled	= false;

	FeatureFlag()
	{
	}

	FeatureFlag(String name)
	{
		this.name = name;
	}

	FeatureFlag(String name, boolean enabled)
	{
		this.name = name;
		this.enabled = enabled;
	}

	public String getName()
	{
		return name;
	}

	public boolean isEnabled()
	{
		return enabled;
	}

	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}