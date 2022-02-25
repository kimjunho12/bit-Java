package com.poscoict.ch08.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("apiTestController")
@RequestMapping("test")
public class ApiController {
	
	@RequestMapping("text")
	public String text() {
		return "text";
	}
	
	@RequestMapping("html")
	public String html() {
		return "html";
	}
	
	@RequestMapping("/json01")
	public String json01() {
		return "json01";
	}
}
