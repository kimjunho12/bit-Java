package com.javaex.oop.point.v4;

public class ColorPoint extends Point {
	private String color;
	
	// 생성자
	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	@Override		// 컴파일러에게 이 메서드가 오버라이딩한 메서드인지 확인
	public void draw(boolean bDraw) {
		// 부모로부터 물려 받은 메서드를 덮어 쓰기
		String message = String.format("색깔점[x=%d, y=%d, color=%s]을 ", super.getX(), y, color);
		message += bDraw ? "그렸습니다." : "지웠습니다.";
		
		System.out.println(message);
		// 부모의 메서드 호출
//		super.draw(bDraw);
	}
}
