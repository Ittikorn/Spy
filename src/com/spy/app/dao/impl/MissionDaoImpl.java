package com.spy.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.util.Assert;

import com.spy.app.dao.MissionDao;
import com.spy.app.model.Mission;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class MissionDaoImpl implements MissionDao
{
	private DataSource dataSource;

	public DataSource getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public boolean create(Mission mission)
	{
		Assert.notNull(mission);
		Assert.notNull(mission.getMissionName());
		Assert.notNull(mission.getMissionDescription());

		String sql = "INSERT INTO `MISSION` (`name`, `description`, `username`) VALUES (?, ?, ?);";

		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, mission.getMissionName());
			ps.setString(2, mission.getMissionDescription());
			ps.setString(3, mission.getUsername());

			isSuccess = ps.execute();

			ps.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return isSuccess;
	}

	@Override
	public boolean deleteByMissionID(int missionID)
	{
		Assert.state(missionID >= 0);

		String sql = "DELETE FROM MISSION WHERE ID = ?";

		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, missionID);

			isSuccess = ps.execute();

			ps.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return isSuccess;
	}

	@Override
	public Mission findByMissionID(int missionID)
	{
		Assert.state(missionID < 0);

		String query = "SELECT * FROM MISSION WHERE ID = ?";

		Connection connection = null;
		Mission mission = null;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, missionID);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				mission = new Mission(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
						rs.getString("username"));
			}

			rs.close();
			ps.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return mission;
	}

	@Override
	public int count()
	{
		String query = "SELECT COUNT(*) AS COUNT FROM MISSION;";

		Connection connection = null;
		int count = -1;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			if (rs.next())
			{
				count = rs.getInt("COUNT");
			}

			rs.close();
			ps.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return count;
	}

	@Override
	public List<Mission> findAll()
	{
		String query = "SELECT * FROM MISSION";

		Connection connection = null;
		List<Mission> missionList = new ArrayList<Mission>();
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				missionList.add(new Mission(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs
						.getString("username")));
			}

			rs.close();
			ps.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return missionList;
	}

	@Override
	public List<Mission> findByUsername(String username)
	{
		Assert.notNull(username);

		String query = "SELECT * FROM MISSION WHERE USERNAME = ?";

		Connection connection = null;
		List<Mission> missionList = new ArrayList<Mission>();
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				missionList.add(new Mission(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs
						.getString("username")));
			}

			rs.close();
			ps.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return missionList;
	}

}
