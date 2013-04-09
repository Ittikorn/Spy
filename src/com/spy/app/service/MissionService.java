package com.spy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spy.app.dao.MissionDao;
import com.spy.app.model.Mission;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class MissionService
{
	@Autowired
	MissionDao missionDao;

	public boolean create(Mission mission)
	{
		return missionDao.create(mission);
	}

	public boolean delete(int missionID)
	{
		return missionDao.deleteByMissionID(missionID);
	}

	public List<Mission> findAll()
	{
		return missionDao.findAll();
	}

	public Mission findByMissionID(int missionID)
	{
		return missionDao.findByMissionID(missionID);
	}

	public List<Mission> findByUsername(String username)
	{
		return missionDao.findByUsername(username);
	}

	public int count()
	{
		return missionDao.count();
	}
}
