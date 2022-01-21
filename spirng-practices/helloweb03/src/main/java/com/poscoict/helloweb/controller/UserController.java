package com.poscoict.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RequestMapping : 클래스(타입) + 메소드(핸들러)
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo vo) { // UserVo의 field명과 input의 name이 같으면 setter를 통해 자동으로 받아옴
		System.out.println(vo);
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam("n") String name) { // n으로 받아옴
		/*
		 * 만일 n 이라는 이름의 파라미터가 없는 경우 400 bad request라는 에러 발생
		 */
		System.out.println(name);
		return "UserController.update()";
	}

	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value = "n", required = true, defaultValue = "") String name, 	// n으로 받아옴 없으면 안되고 만약 없으면 ""로 초기화
			@RequestParam(value = "a", required = true, defaultValue = "0") Integer age) { 	// a로 받아옴 없으면 안되고 만약 없으면 0으로 초기화
		System.out.println("-----" + name + "-----");
		System.out.println("-----" + age + "-----");
		return "UserController.update2()";
	}

}
