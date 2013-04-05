package com.spy.app.dao;

import java.util.List;

import com.spy.app.model.User;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public interface UserDao
{
	public boolean create(User user);

	public User findByUsername(String username);

	public int count();

	public List<User> findAll();
}