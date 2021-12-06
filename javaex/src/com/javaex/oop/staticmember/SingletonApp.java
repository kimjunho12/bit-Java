package com.javaex.oop.staticmember;

public class SingletonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
				
		// 객체 주소가 같으면 같은 객체
		System.out.println("s1, s2가 같은 객체? " + (s1 == s2));
	}

}
