package com.ds.practice.test.innerclass;

import com.ds.practice.test.innerclass.Outter2.Inner;

class Outter2 {
	
	private int num = 10;
	private static int num2 = 3;
	
	static class Inner {
		public void disp() {
//			System.out.println(num);
			System.out.println(num2);
		}
	}
	
}


public class StaticInnerTest {

	public static void main(String[] args) {
		Inner i = new Inner();
		i.disp();

	}

}
