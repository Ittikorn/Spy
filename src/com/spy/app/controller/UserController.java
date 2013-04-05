package com.spy.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spy.app.service.UserService;

@Controller
@RequestMapping("/user*")
public class UserController
{
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String getUser(ModelMap model)
	{
		model.addAttribute("userList", userService.findAll());

		return "user_management";
	}
}
