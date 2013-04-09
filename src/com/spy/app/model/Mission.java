package com.spy.app.model;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class Mission
{
	private int missionID;

	private String missionName;

	private String missionDescription;

	private String username;

	public Mission()
	{
		super();
	}

	public Mission(String missionName, String missionDescription)
	{
		super();
		this.missionName = missionName;
		this.missionDescription = missionDescription;
	}

	public Mission(int missionID, String missionName, String missionDescription)
	{
		super();
		this.missionID = missionID;
		this.missionName = missionName;
		this.missionDescription = missionDescription;
	}

	public Mission(String missionName, String missionDescription, String username)
	{
		super();
		this.missionName = missionName;
		this.missionDescription = missionDescription;
		this.username = username;
	}

	public Mission(int missionID, String missionName, String missionDescription, String username)
	{
		super();
		this.missionID = missionID;
		this.missionName = missionName;
		this.missionDescription = missionDescription;
		this.username = username;
	}

	public int getMissionID()
	{
		return missionID;
	}

	public void setMissionID(int missionID)
	{
		this.missionID = missionID;
	}

	public String getMissionName()
	{
		return missionName;
	}

	public void setMissionName(String missionName)
	{
		this.missionName = missionName;
	}

	public String getMissionDescription()
	{
		return missionDescription;
	}

	public void setMissionDescription(String missionDescription)
	{
		this.missionDescription = missionDescription;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
}
