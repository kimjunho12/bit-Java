package com.javaex.oop.shape.v2;

public class Circle extends Shape implements Drawable {
	protected double r;
	
	public Circle(int x, int y, double r) {
		super(x, y);
		this.r = r;
	}

	@Override
	public void draw() {
		System.out.printf("원[x=%d, y=%d, r=%f, area=%f]을 그렸어요%n", x, y, r, area());

	}

	@Override
	public double area() {
		return Math.PI * Math.pow(r, 2);
	}

}
