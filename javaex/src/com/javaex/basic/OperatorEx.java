package com.javaex.basic;

public class OperatorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		arithOperEX();
//		prefixIncrEX();
//		suffixIncrEX();
//		logicalOperEX();
//		bitOperEX();
//		bitShiftOperEX();
		conditionalOperEX();
		
	}
	
	// 3항 연산자
	private static void conditionalOperEX() {
		int a = 10;
		
		// a가 짝수면 짝수, 홀수면 홀수 출력
		System.out.println(a + "는 " + (a % 2 == 0 ? "짝수" : "홀수"));
		
		int score = 85;
		String message;
		// 점수가 90점 이상이면 Good, 50점 미만이면 Fail, 아니면 Pass
		System.out.println(message = score >= 90 ? "Good" : (score < 50 ? "Fail" : "Pass"));
		System.out.println(message);
	}
	
	// 비트 시프트
	private static void bitShiftOperEX() {
		int val = 1;

		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(val << 3));
		System.out.println(val << 3);
		
		val = 0b1000;
		System.out.println(Integer.toBinaryString(val));
		System.out.println(Integer.toBinaryString(val >> 2));
		
	}
	
	// 비트연산자
	private static void bitOperEX() {
		// int에서만
		// 비트 단위의 미세한 제어에 이용
		int b1 = 0b11011101;
		int mask = 0b10101010;
		System.out.println(Integer.toBinaryString(b1));
		System.out.println(Integer.toBinaryString(mask));
		
		System.out.println(Integer.toBinaryString(b1 & mask));
		System.out.println(Integer.toBinaryString(b1 | mask));
		System.out.println(Integer.toBinaryString(~b1));
	}
	
	// 비교, 논리연산
	private static void logicalOperEX() {
		// 비교연산자 : >, >=, <, <=, == (equal), != (not equal)
		// 논리연산자 : 논리곱(AND &&), 논리합(OR &&), 논리부정(NOT !)
		
		int a = 5;
		
		// a가 0 초과, 10 미만의 값?
		// 조건 1 : a > 0
		// 조건 2 : a < 10
		// 결과   : 조건 1 AND 조건2
		boolean b1 = a > 0;			// true
		boolean b2 = a < 10;		// true
		
		boolean result = b1 && b2;	// 논리곱 연산
		System.out.println("b1 && b2 = " + result);
		
		// a가 0이하 이거나 10이상의 값
		b1 = a <= 0;
		b2 = a >= 10;
		result = b1 || b2;
		System.out.println("b1 || b2 = " + result);
		
		// 논리 부정(NOT !)
		System.out.println("!b == " + !result);
	}
	
	// 후위증감
	private static void suffixIncrEX() {
		int a = 7;
		int b = 0;
		
		b = a++;
		System.out.println("b:" + b);
		System.out.println("a:" + a);
				
	}
	

	// 전위증감
	private static void prefixIncrEX() {
		int a = 7;
		int b = 0;
		
		b = ++a;
		System.out.println("b:" + b);
		System.out.println("a:" + a);
				
	}
	
	// 산술연산자
	private static void arithOperEX() {
		int a = 7;
		int b = 3;
		
		// 부호 연산자(+, -)
		System.out.println(-a);		// -1 * a
		
		// 산술 연산자(+, -, *, /)
		System.out.println(a / b);	// int / int -> int(나눗셈의 몫)
		System.out.println(a % b);	// 정수 나눗셈의 나머지
		
//		System.out.println(a / 0);		// int / 0 -> Error
		System.out.println(7.0 / 0);	// Infinity
		System.out.println(7.0 / 0 + 100); // Infinity가 포함된 산술식 -> Infinity
		
		// Infinity Check
		System.out.println(Double.isInfinite(7.0 / 0));
		
		// Data가 NaN인지 확인
		System.out.println(0.0 / 0.0);
		System.out.println(Double.isNaN(0.0 / 0.0));
		System.out.println(Double.isNaN(7.0 / 0.0));
	}
}
