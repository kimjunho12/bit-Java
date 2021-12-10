package com.ds.practice.test.innerclass;

import com.ds.practice.test.innerclass.Outter.Inner;

class Outter {
	
	private int num = 10;
	private static int num2 = 3;
	
	class Inner {
		public void disp() {
			System.out.println(num);
			System.out.println(num2);
		}
	}
	
}


public class MemberInnerTest {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Outter o = new Outter();
//		
//		Inner i = o.new Inner();
		

		Inner i = new Outter().new Inner();
		i.disp();

	}

}
