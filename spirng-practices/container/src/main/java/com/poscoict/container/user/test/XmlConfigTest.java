package com.poscoict.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.poscoict.container.user.User;
import com.poscoict.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		testBeanFactory01();
		testBeanFactory02();
		
		testApplicationContext01();
		testApplicationContext02();
	}
	
	// XML Auto Configuration (Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext01.xml");
		
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		// bean id가 자동으로 설정 됨
		user1 = (User1) ac.getBean("user1");
		System.out.println(user1.getName());
	}
	
	// XML Bean Configuration (Explicit Configuration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/poscoict/container/config/user/applicationContext02.xml");
		
		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());
		
		User user = null;
		// id로 빈 가져오기
		user = (User) ac.getBean("user");
		System.out.println(user);
		
		// name으로 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user);
		
		// type으로 가져오기 (같은 타입의 빈이 두 개 이상 있으면, type으로 가져오기는 실패!)
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		// 2개 파라미터 생성자로 생성된 빈 가져오기
		user = (User) ac.getBean("user3");
		System.out.println(user);
		
		// 2개 파라미터 생성자로 생성된 빈 가져오기2
		user = (User) ac.getBean("user4");
		System.out.println(user);
		
		// Setter를 사용한 빈 가져오기
		user = (User) ac.getBean("user5");
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기2 & DI
		user = (User) ac.getBean("user6");
		System.out.println(user);
		
		// setter를 사용한 빈 가져오기3 - List Property
		user = (User) ac.getBean("user7");
		System.out.println(user);
		
	}

	// XML Auto Configuration (Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext01.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// bean id가 자동으로 설정 됨
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}

	// XML Bean Configuration (Explicit Configuration)
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/poscoict/container/config/user/applicationContext02.xml"));
		
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());
		
		// bean id가 자동으로 설정 되지 않음
		// 명시적으로 설정 필요 (xml bean에 id=""으로 설정)
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}
}
