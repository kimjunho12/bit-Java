package com.javaex.api.objectclass.v4;

// v3. 얕은 복제 : 객체의 필드데이터를 단순 복제
// Cloneable 인터페이스 구현 필요
public class Point implements Cloneable {
	private int x , y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// 객체 문자열 포맷을 반환
		return String.format("Point(%d, %d)", x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}
		return super.equals(obj);
	}
	
	public Point getClone() {
		Point clone = null;		// 복제본
		
		try {
			clone = (Point) clone();	
		} catch (CloneNotSupportedException e ) {
			System.err.println("복제 실패\n" + e.getMessage());
		}
		
		return clone;
	}

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

}
