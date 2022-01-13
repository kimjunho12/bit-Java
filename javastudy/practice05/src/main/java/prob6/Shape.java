package prob6;

public abstract class Shape {
	protected double width;
	protected double height;

	public Shape(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public abstract double getArea(); // 넓이

	public abstract double getPerimeter(); // 둘레

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double d) {
		this.height = d;
	}

}
