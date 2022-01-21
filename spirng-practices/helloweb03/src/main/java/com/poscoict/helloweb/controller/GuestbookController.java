package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping : 클래스(타입) 단독 매핑
 *
 */

@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {

	@ResponseBody
	@RequestMapping
	public String list() {		// /guestbook/list
		return "GuestbookController.list()";
	}

	@ResponseBody
	@RequestMapping
	public String delete() {	// /guestbook/delete
		return "GuestbookController.delete()";
	}

}
