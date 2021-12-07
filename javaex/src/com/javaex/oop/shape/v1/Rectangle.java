package com.javaex.oop.shape.v1;

public class Rectangle extends Shape {
	// 추가 필드
	protected int width, height;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.printf("사각형[x=%d, y=%d, w=%d, h=%d, area=%f]을 그렸어요%n", x, y, width, height, area());
	}

	@Override
	public double area() {
		return width * height;
	}
}
