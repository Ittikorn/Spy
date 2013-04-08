package com.spy.app.dao;

import java.util.List;

import com.spy.app.model.Mission;

public interface MissionDao
{
	public boolean create(Mission mission);

	public boolean deleteByMissionID(int missionID);

	public Mission findByMissionID(int missionID);

	public int count();

	public List<Mission> findAll();

	public List<Mission> findByUsername(String username);

}
