package com.spy.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Krittanan.Pingclasai
 * @version 3.4.2013.0
 * 
 */

@Controller
@RequestMapping("/*")
public class HomePageController
{
	@RequestMapping
	public String goToHomepage()
	{
		return "home_page";
	}
}