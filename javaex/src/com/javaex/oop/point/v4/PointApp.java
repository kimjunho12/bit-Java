package com.javaex.oop.point.v4;

public class PointApp {

	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		p1.draw();
		p1.draw(true);
		p1.draw(false);
		
		Point p2 = new Point(30, 40);
		p2.draw();
		p2.draw(true);
		p2.draw(false);
		
		ColorPoint cp1 = new ColorPoint(10, 20, "RED");
		cp1.draw(true);
		cp1.childsMethod();
		
		// 다형성 : 부모타입으로 자식객체 참조
		Point cp2 = new ColorPoint(30, 40, "GREEN");
		cp2.draw(true);
//		cp2.childsMethod(); 자식 메소드 호출 불가
	}

}
