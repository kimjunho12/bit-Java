package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LandingController {
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("favicon.ico")
	@ResponseBody
	public void returnNoFavicon() {
		
	}
}
