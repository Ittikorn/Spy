package com.spy.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.util.Assert;

import com.spy.app.dao.UserDao;
import com.spy.app.dto.AuthorityDto;
import com.spy.app.model.User;
import com.spy.app.utility.PasswordUtility;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class UserDaoImpl implements UserDao
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
	public User findByUsername(String username)
	{
		Assert.notNull(username);

		String query = "SELECT * FROM USER WHERE USERNAME = ?";

		Connection connection = null;
		User user = null;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				user = new User(rs.getString("username"), rs.getString("password"), AuthorityDto.getAuthority(rs
						.getInt("authority")));
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

		return user;
	}

	@Override
	public boolean create(User user)
	{
		Assert.notNull(user);
		Assert.notNull(user.getUsername());
		Assert.notNull(user.getPassword());
		Assert.notNull(user.getAuthority());

		String sql = "INSERT INTO `USER` (`username`, `password`, `authority`) VALUES (?, ?, ?)";

		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, PasswordUtility.getMD5(user.getPassword()));
			ps.setInt(3, user.getAuthority().getRole());

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
	public int count()
	{
		String query = "SELECT COUNT(*) AS COUNT FROM USER;";

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
}
