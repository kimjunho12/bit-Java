package com.poscoict.ch08.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscoict.ch08.controller.dto.JsonResult;
import com.poscoict.ch08.controller.dto.XmlResult;
import com.poscoict.ch08.controller.vo.GuestbookVo;

@Controller
@RequestMapping("/api")
public class ApiController {

	@ResponseBody
	@RequestMapping("/text")
	public String text() {
		return "Text 데이터";
	}

	@ResponseBody
	@RequestMapping("/html")
	public String html() {
		return "<h1> AJAX 연습 </h1><p>html 데이터</p>";
	}
	
	@ResponseBody
	@RequestMapping("/xml")
	public Object xml()	{
		XmlResult.GuestbookVo vo = new XmlResult.GuestbookVo();
		vo.setNo(1L);
		vo.setName("둘리");
		vo.setMessage("호이~");

		return XmlResult.success(vo);
	}

	@ResponseBody
	@RequestMapping(value = "/json")
	public JsonResult json() {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(1L);
		vo.setName("둘리");
		vo.setMessage("처신 잘하라고~ ㅋㅋㅋㅋㅋㅋ");

		JsonResult jsonResult = JsonResult.success(vo);

		return jsonResult;
	}

	@ResponseBody
	@RequestMapping(value = "/post01", method = RequestMethod.POST)
	public JsonResult post01(GuestbookVo vo) {
		System.out.println(vo);

		// service -> repository : DB insert 성공 한 후,
		vo.setNo(1L);
		vo.setPassword("");

		return JsonResult.success(vo);
	}

	@ResponseBody
	@RequestMapping(value = "/post02", method = RequestMethod.POST)
	public JsonResult post02(@RequestBody GuestbookVo vo) {
		System.out.println(vo);

		// service -> repository : DB insert 성공 한 후,
		vo.setNo(1L);
		vo.setPassword("");

		return JsonResult.success(vo);
	}
}
