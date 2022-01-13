package com.poscoict.guestbook.dao.test;

import java.util.List;

import com.poscoict.guestbook.dao.GuestbookDao;
import com.poscoict.guestbook.vo.GuestbookVo;

public class GuestbookDaoTest {
	public static void main(String[] args) {
		testFindAll();
		testInsert();
		testFindAll();
		testDelete();
		testFindAll();
	}

	private static void testDelete() {
		long no = 2;
		String password = "1234";
		boolean result = new GuestbookDao().delete(no, password);

		System.out.println(result);
	}

	private static void testInsert() {
		GuestbookVo vo = new GuestbookVo();
		vo.setName("홍길동");
		vo.setPassword("1234");
		vo.setMessage("hi");
		boolean result = new GuestbookDao().insert(vo);

		System.out.println(result);
	}

	private static void testFindAll() {
		List<GuestbookVo> list = new GuestbookDao().findAll();
		for (GuestbookVo vo : list) {
			System.out.println(vo);
		}
	}
}
