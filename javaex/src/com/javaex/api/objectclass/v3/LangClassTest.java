package com.javaex.api.objectclass.v3;

public class LangClassTest {

	public static void main(String[] args) {
		Point p = new Point(10, 10);

		System.out.println("p = " + p);
		
		Point p2 = p.getClone();		// 복제
		System.out.println("p2 = " + p2);
		
		System.out.println("p == p2 ? " + ((p == p2)));
		p.setX(100);
		p.setY(200);
		
		System.out.println("p = " + p);
		System.out.println("p2 = " + p2);
	}

}
