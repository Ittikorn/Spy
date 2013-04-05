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

	private String firstname;

	private String lastname;

	private String alias;

	public User()
	{
		super();
	}

	public User(String username, String password, Authority authority, String firstname, String lastname, String alias)
	{
		super();
		this.username = username;
		this.password = password;
		this.authority = authority;
		this.firstname = firstname;
		this.lastname = lastname;
		this.alias = alias;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}

	public String getAlias()
	{
		return alias;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
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
