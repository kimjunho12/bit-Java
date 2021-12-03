package com.javaex.practice;

import java.util.Scanner;

public class Practice01_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p6(); System.out.println();
//		p7(); System.out.println();
//		p8(); System.out.println();
//		p9(); System.out.println();
//		p10(); System.out.println();
		
	}
	
	private static void p6() {
		// 입력 값 홀수 -> 입력 값까지의 홀수 합
		// 입력 값 짝수 -> 입력 값까지의 짝수 합
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int n = sc.nextInt();	sc.close();
		int sum = 0;
		
		while(n > 0) {
			sum += n;
			n = n-2;
		}
		System.out.println(sum);
		
		
	}

}
