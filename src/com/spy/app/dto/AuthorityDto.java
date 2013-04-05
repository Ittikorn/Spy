package com.spy.app.dto;

import com.spy.app.utility.Authority;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class AuthorityDto
{
	static Authority[] authorityArray;

	private AuthorityDto()
	{
	}

	static
	{
		authorityArray = Authority.values();
	}

	public static Authority getAuthority(int role)
	{
		for (Authority a : authorityArray)
		{
			if (a.getRole() == role)
			{
				return a;
			}
		}

		return null;
	}

	public static Authority getAuthority(String name)
	{
		for (Authority a : authorityArray)
		{
			if (a.getName().equalsIgnoreCase(name))
			{
				return a;
			}
		}

		return null;
	}
}
