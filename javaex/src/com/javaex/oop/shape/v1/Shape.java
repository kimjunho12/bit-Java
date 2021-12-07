package com.javaex.oop.shape.v1;

// 추상 클래스
public abstract class Shape {
	protected int x, y;
	
	public Shape (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// 추상클래스 내부에는 반드시 하나 이상의 추상메서드가 있어야함
	public abstract void draw();
	public abstract double area();
}
