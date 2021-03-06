package com.spy.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spy.app.dao.UserDao;
import com.spy.app.model.User;
import com.spy.app.utility.Authority;
import com.spy.app.utility.PasswordUtility;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class UserService implements UserDetailsService
{
	@Autowired
	UserDao userDao;

	public void create(User user)
	{
		user.setPassword(PasswordUtility.getMD5(user.getPassword()));

		userDao.create(user);
	}

	public User findByUsername(String username)
	{
		return userDao.findByUsername(username);
	}

	public int count()
	{
		return userDao.count();
	}

	public List<User> findAll()
	{
		return userDao.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = findByUsername(username);

		if (user == null)
		{
			return null;
		}

		org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), true, true, true, true, getAuthorities(user.getAuthority()
						.getRole()));

		return userDetail;
	}

	public List<GrantedAuthority> getAuthorities(Integer role)
	{
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();

		if (role.intValue() == Authority.ROLE_ADMIN.getRole())
		{
			authList.add(new SimpleGrantedAuthority(Authority.ROLE_ADMIN.getName()));
			authList.add(new SimpleGrantedAuthority(Authority.ROLE_USER.getName()));
		}
		else if (role.intValue() == Authority.ROLE_USER.getRole())
		{
			authList.add(new SimpleGrantedAuthority(Authority.ROLE_USER.getName()));
		}

		return authList;
	}

	public boolean deleteByUsername(String username)
	{
		return userDao.deleteByUsername(username);
	}

	public boolean updateProfile(String username, String firstname, String lastname, String alias)
	{
		User user = findByUsername(username);

		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setAlias(alias);

		return userDao.update(user);
	}

	public boolean updatePassword(String username, String password)
	{
		User user = findByUsername(username);

		user.setPassword(PasswordUtility.getMD5(password));

		return userDao.update(user);
	}
}
