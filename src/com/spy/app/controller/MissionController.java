package com.spy.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spy.app.model.Mission;
import com.spy.app.service.MissionService;
import com.spy.app.service.UserService;

@Controller
@RequestMapping("/mission*")
public class MissionController
{
	@Autowired
	MissionService missionService;

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String goToMissionManagementPage(ModelMap model)
	{
		model.addAttribute("missionList", missionService.findAll());
		model.addAttribute("userList", userService.findAll());

		return "/mission/management";
	}

	@RequestMapping(method = RequestMethod.POST, value = "create")
	public String createMission(HttpServletRequest request, ModelMap model)
	{
		String missionName = request.getParameter("name");
		String missionDescription = request.getParameter("description");
		String username = request.getParameter("username");

		missionService.create(new Mission(missionName, missionDescription, username));

		model.addAttribute("missionList", missionService.findAll());
		model.addAttribute("userList", userService.findAll());
		
		return "/mission/management";
	}

	@RequestMapping(method = RequestMethod.POST, value = "delete")
	public String deleteMission(HttpServletRequest request, ModelMap model)
	{
		int missionID = Integer.parseInt(request.getParameter("id"));

		missionService.delete(missionID);

		model.addAttribute("missionList", missionService.findAll());
		model.addAttribute("userList", userService.findAll());
		
		return "/mission/management";
	}
}
