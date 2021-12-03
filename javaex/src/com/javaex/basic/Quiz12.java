package com.javaex.basic;

public class Quiz12 {
	public static void main(String[] arg) {
		// Q1
		String phoneNumber = "010-3398-2074";
		// Q2
		float interestRate = 0.031f;
		// Q3
		System.out.println("1" + "3");		// 문자열 이어 붙이기
		System.out.println(true + "Java");	// 문자열 처럼 취급
		System.out.println('A' + 'B');		// ASCII Code 합 65 + 66 = 131
		System.out.println('1' + 2);		// ASCII Code 합 81 + 2 = 83
		System.out.println('J' + "ava");	// 문자열 이어 붙이기
//		System.out.println(false + null);	// Error Occur ( The operator + is undefined for the argument type(s) boolean, null)
		// Q4
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		byte b2 = (byte)i;
		char ch2 = (char)b;
		short s = (short)ch;
		float f = l;//(float)l;
		int i2 = ch;//(int)ch;
		
		System.out.printf("%d %c %s %f %d",b2, ch2, s, f, i2);
		
		
		// Q1
		int a = 3; b = 6;
		char c = 'A';
		System.out.println(a%2==0?true:false);
		System.out.println(b%3==0?true:false);
		
		boolean r1 = (a%2==0?true:false) && (b%3==0?true:false);
		System.out.println(r1);
		char r2 = (char) (c + 4);
		System.out.println(r2);
		
		// Q2
		int balls = 136;
		int cap = 10;
		
		System.out.println(balls>=cap?balls/cap:0);
		
		// Q3
		int num = 13579;
		System.out.println(num/100*100);
		
		// Q4
		ch = 'A';
		System.out.println((char) (ch + 32));
		
		// Q5
		int num1 = 13579;
		int num2 = 13579;
		System.out.println((++num1 + 1) == (num2++ + 1)?"같음":"다름");		
	}
}
