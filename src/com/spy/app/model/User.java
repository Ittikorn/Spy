package com.spy.app.model;

import com.spy.app.utility.Authority;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class User
{
	private String username;

	private String password;

	private Authority authority;

	public User()
	{
		super();
	}

	public User(String username, String password, Authority authority)
	{
		super();
		this.username = username;
		this.password = password;
		this.authority = authority;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Authority getAuthority()
	{
		return authority;
	}

	public void setAuthority(Authority authority)
	{
		this.authority = authority;
	}
}
