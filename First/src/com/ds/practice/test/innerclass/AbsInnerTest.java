package com.ds.practice.test.innerclass;

abstract class Abs {
	abstract void disp();
}

class Outter4 {
	
	private int num = 10;
	private static int num2 = 3;
	
	public void output() {
		new Abs() {
			@Override
			void disp() {
				System.out.println(num);
				System.out.println(num2);
			}
		}.disp();
	}
}


public class AbsInnerTest {
	public static void main(String[] args) {
		new Outter4().output();
	}

}
