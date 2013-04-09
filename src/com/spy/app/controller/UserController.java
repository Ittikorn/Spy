package com.spy.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spy.app.model.User;
import com.spy.app.service.MissionService;
import com.spy.app.service.UserService;
import com.spy.app.utility.Authority;
import com.spy.app.utility.PasswordUtility;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

@Controller
@RequestMapping("/user*")
public class UserController
{
	@Autowired
	UserService userService;

	@Autowired
	MissionService missionService;

	@RequestMapping(method = RequestMethod.GET)
	public String getToUserManagementPage(ModelMap model)
	{
		model.addAttribute("userList", userService.findAll());

		return "/user/management";
	}

	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String goToUserProfilePage(HttpServletRequest request, ModelMap model)
	{
		String username = request.getParameter("username");

		model.addAttribute("user", userService.findByUsername(username));
		model.addAttribute("missionList", missionService.findByUsername(username));

		return "/user/profile";
	}

	@RequestMapping(method = RequestMethod.POST, value = "create")
	public String createUser(HttpServletRequest request, ModelMap model)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String alias = request.getParameter("alias");

		User user = new User(username, password, Authority.ROLE_USER, firstname, lastname, alias);

		userService.create(user);

		model.addAttribute("userList", userService.findAll());

		return "/user/management";
	}

	@RequestMapping(method = RequestMethod.POST, value = "delete")
	public String deleteUser(HttpServletRequest request, ModelMap model)
	{

		String username = (String) request.getParameter("username");

		userService.deleteByUsername(username);

		model.addAttribute("userList", userService.findAll());

		return "/user/management";
	}

	@RequestMapping(method = RequestMethod.POST, value = "update/profile")
	public String updateUserProfile(HttpServletRequest request, ModelMap model)
	{
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String alias = request.getParameter("alias");

		userService.updateProfile(username, firstname, lastname, alias);

		model.addAttribute("user", userService.findByUsername(username));
		model.addAttribute("missionList", missionService.findByUsername(username));

		return "/user/profile";
	}

	@RequestMapping(method = RequestMethod.POST, value = "update/password")
	public String updateUserPassowrd(HttpServletRequest request, ModelMap model)
	{
		String username = request.getParameter("username");

		User user = userService.findByUsername(username);
		if (user != null)
		{
			String oldPassword = request.getParameter("old_password");
			if (user.getPassword().equals(PasswordUtility.getMD5(oldPassword)))
			{
				String newPassword = request.getParameter("new_password");
				userService.updatePassword(username, newPassword);
			}
		}

		model.addAttribute("user", userService.findByUsername(username));
		model.addAttribute("missionList", missionService.findByUsername(username));

		return "/user/profile";
	}
}
