package com.spy.app.utility;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public enum Authority
{
	ROLE_ADMIN(1, "ROLE_ADMIN"), ROLE_USER(2, "ROLE_USER");

	private int role;
	private String name;

	private Authority(int role, String name)
	{
		this.role = role;
		this.name = name;
	}

	public int getRole()
	{
		return role;
	}

	public void setRole(int role)
	{
		this.role = role;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
