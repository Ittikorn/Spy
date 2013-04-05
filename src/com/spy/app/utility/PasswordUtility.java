package com.spy.app.utility;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

public class PasswordUtility
{
	private static final String SALT = "mysaltvalue";

	public static String getMD5(String password)
	{
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();

		return encoder.encodePassword(password, SALT);
	}
}