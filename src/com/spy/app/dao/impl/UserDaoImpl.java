package com.spy.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.util.Assert;

import com.spy.app.dao.UserDao;
import com.spy.app.dto.AuthorityDto;
import com.spy.app.model.User;

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
						.getInt("authority")), rs.getString("firstname"), rs.getString("lastname"),
						rs.getString("alias"));
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
		Assert.notNull(user.getFirstname());
		Assert.notNull(user.getLastname());
		Assert.notNull(user.getAlias());

		String sql = "INSERT INTO `USER` (`username`, `password`, `authority`, `firstname`, `lastname`, `alias`) VALUES (?, ?, ?, ?, ?, ?);";

		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAuthority().getRole());
			ps.setString(4, user.getFirstname());
			ps.setString(5, user.getLastname());
			ps.setString(6, user.getAlias());

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

	@Override
	public List<User> findAll()
	{
		String query = "SELECT * FROM USER";

		Connection connection = null;
		List<User> userList = new ArrayList<User>();
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				userList.add(new User(rs.getString("username"), rs.getString("password"), AuthorityDto.getAuthority(rs
						.getInt("authority")), rs.getString("firstname"), rs.getString("lastname"), rs
						.getString("alias")));
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

		return userList;
	}

	@Override
	public boolean deleteByUsername(String username)
	{
		Assert.notNull(username);

		String sql = "DELETE FROM USER WHERE USERNAME = ?";

		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);

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
	public boolean update(User user)
	{
		Assert.notNull(user);
		Assert.notNull(user.getUsername());
		Assert.notNull(user.getPassword());
		Assert.notNull(user.getAuthority());
		Assert.notNull(user.getFirstname());
		Assert.notNull(user.getLastname());
		Assert.notNull(user.getAlias());

		String sql = "UPDATE USER SET USERNAME = ?, PASSWORD = ?, AUTHORITY = ?, FIRSTNAME = ?, LASTNAME = ?, ALIAS = ? WHERE USERNAME = ?";

		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAuthority().getRole());
			ps.setString(4, user.getFirstname());
			ps.setString(5, user.getLastname());
			ps.setString(6, user.getAlias());
			ps.setString(7, user.getUsername());

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
}
