package com.ds.practice.test.innerclass;

class Outter3 {
	
	private int num = 10;
	private static int num2 = 3;
	
	public void output() {
		 class Inner {
			public void disp() {
				System.out.println(num);
				System.out.println(num2);
			}			
		}

		Inner i = new Inner();
		i.disp();
	}
}


public class LocalInnerTest {

	public static void main(String[] args) {
		Outter3 o = new Outter3();
		o.output();
	}

}
