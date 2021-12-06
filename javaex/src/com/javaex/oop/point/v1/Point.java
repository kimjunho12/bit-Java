package com.javaex.oop.point.v1;

// v1. 필드, getter/setter
public class Point {
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void draw()	{
		System.out.printf("점[x=%d, y=%d]을 그렸습니다.%n", x, y);
	}
	
}
