package com.javaex.practice;import java.util.Scanner;

import org.w3c.dom.ranges.Range;

public class Practice01_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p1(); System.out.println();
		p2(); System.out.println();
		p3(); System.out.println();
		p4(); System.out.println();
		p5(); System.out.println();
		
	}
	
	private static void p1() {
		for (int i = 1; i <= 100; ++i) {
			if (i % 5 == 0 && i % 7 == 0)
				System.out.println(i);
		}
	}
	
	private static void p2() {
		System.out.println("숫자를 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		
		for (int i = 1; i <=n; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.printf("%d", i);
			}
			System.out.println();
		}
	}
	
	private static void p3() {
		for (int i = 1; i < 10; ++i) {
			for (int j = 2; j < 10; ++j) {
				System.out.printf("%d*%d=%d\t", j, i, j*i);
			}
			System.out.println();
		}
	}
	
	private static void p4() {
		for (int i = 1; i <= 10; ++i) {
			for (int j = 0; j < 10; ++j) {
				System.out.printf("%d\t", i+j);
			}
			System.out.println();
		}
	}
	
	private static void p5() {
		System.out.println("숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		int max = 0;
		for (int i = 0; i < 6; ++i) {
			int tmp;
			System.out.printf("숫자: ");
			tmp = sc.nextInt();
			if (max < tmp)
				max = tmp;
					
		}
		System.out.println("최대값은 " + max + "입니다.");
		sc.close();
	}

}
