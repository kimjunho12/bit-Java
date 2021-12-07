package com.javaex.api.objectclass.v2;

public class LangClassTest {

	public static void main(String[] args) {
		Point p = new Point(10, 10);

		Point p2 = new Point(10, 10);
		
		System.out.println("p==p2 ? " + (p==p2));
		System.out.println("p.equals(p2) ? " + p.equals(p2));
	}

}
