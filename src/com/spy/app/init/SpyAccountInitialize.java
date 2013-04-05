package com.spy.app.init;

import org.springframework.beans.factory.annotation.Autowired;

import com.spy.app.model.User;
import com.spy.app.service.UserService;
import com.spy.app.utility.Authority;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class SpyAccountInitialize
{
	@Autowired
	UserService userService;

	public void init()
	{
		if (userService.count() == 0)
		{
			userService.create(new User("admin", "passworD1", Authority.ROLE_ADMIN, "James", "Bond", "007"));
		}
	}
}
