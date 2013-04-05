package com.spy.app.init;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class SpyDatabaseInitialize
{
	private boolean create = false;

	private DataSource dataSource;

	private Map<String, String> maps;

	public SpyDatabaseInitialize()
	{
		maps = new HashMap<String, String>();

		maps.put(
				"USER",
				"CREATE TABLE `USER` (`username` char(30) NOT NULL DEFAULT '',`password` char(255) NOT NULL DEFAULT '',`authority` int(11) NOT NULL,`firstname` char(30) NOT NULL DEFAULT '',`lastname` char(30) NOT NULL DEFAULT '',`alias` char(30) NOT NULL DEFAULT '',PRIMARY KEY (`username`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;");
	}

	public void init()
	{
		if (create)
		{
			Iterator<Entry<String, String>> it = maps.entrySet().iterator();

			while (it.hasNext())
			{
				Entry<String, String> pairs = it.next();

				dropTable(pairs.getKey());
				createTable(pairs.getValue());

				it.remove();
			}
		}
	}

	private boolean createTable(String sql)
	{
		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);

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

	private boolean dropTable(String tableName)
	{
		String sql = String.format("DROP TABLE IF EXISTS %s", tableName);

		Connection connection = null;
		boolean isSuccess = false;
		try
		{
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);

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

	public boolean isCreate()
	{
		return create;
	}

	public void setCreate(boolean create)
	{
		this.create = create;
	}

	public DataSource getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
}