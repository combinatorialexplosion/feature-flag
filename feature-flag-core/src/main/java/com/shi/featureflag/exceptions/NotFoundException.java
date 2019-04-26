package com.shi.featureflag.exceptions;

/**
 * Thrown if a feature flag is not found in a FeatureFlagStore
 *
 * @author Seamus
 *
 */
public class NotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public NotFoundException()
	{
		super("flag not found");
	}

	public NotFoundException(String flagName)
	{
		super(flagName + "not found");
	}
}