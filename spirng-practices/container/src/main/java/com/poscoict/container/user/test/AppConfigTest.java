package com.poscoict.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.poscoict.container.config.user.AppConfig01;
import com.poscoict.container.user.User;

public class AppConfigTest {
	
	public static void main(String[] args) {
		testAppConfig01();
		testAppConfig02();
	}
	
	// Java Config 1
	// 직접 자바 클래스(Config Class)를 전달
	public static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user = ac.getBean(User.class);
		System.out.println(user);
	}
	
	// Java Config 2
	// 직접 자바 클래스(Config Class)를 전달
	// Class에 @Configuration 추가
	public static void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.poscoict.container.config.user");
		
		User user = ac.getBean(User.class);
		System.out.println(user);
	}

}
