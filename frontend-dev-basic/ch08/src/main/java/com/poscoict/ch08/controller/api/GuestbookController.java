package com.poscoict.ch08.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poscoict.ch08.controller.dto.JsonResult;
import com.poscoict.ch08.controller.vo.GuestbookVo;

@Controller
@RequestMapping("/api/guestbook")
public class GuestbookController {

	@ResponseBody
	@RequestMapping("/add")
	public JsonResult ex01(@RequestBody GuestbookVo vo) {
		// guestbookService.addMessage(vo);
		vo.setNo(1L);
		vo.setPassword("");

		return JsonResult.success(vo);
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonResult ex02(@RequestParam(value = "sn", required = true, defaultValue = "-1") Long sn ) {
		// guestbookService.getMessageList(sn);
		List<GuestbookVo> list = new ArrayList<>();
		GuestbookVo vo1 = new GuestbookVo();
		vo1.setNo(1L);
		vo1.setName("둘리");
		vo1.setMessage("처신좀");
		list.add(vo1);
		GuestbookVo vo2 = new GuestbookVo();
		vo2.setNo(2L);
		vo2.setName("또치");
		vo2.setMessage("떨 한대 어때?");
		list.add(vo2);
		GuestbookVo vo3 = new GuestbookVo();
		vo3.setNo(3L);
		vo3.setName("고길동");
		vo3.setMessage("집에선 안피기로 했잖아");
		list.add(vo3);

		return JsonResult.success(list);
	}

	@ResponseBody
	@RequestMapping("/delete/{no}")
	public JsonResult ex03(@PathVariable(name = "no") Long no, @RequestParam(value = "password", required = true, defaultValue = "") String password) {

		JsonResult jsonResult;

		// boolean result = guestbookService.deleteMessage(no, password);

		Long data = 0L;
		// 1. 삭제가 안된 경우 (실패)
//		if (result == false)
		data = -1L;

		// 2. 삭제가 된 경우 (성공)
		data = no;

		return JsonResult.success(data);
	}

}
