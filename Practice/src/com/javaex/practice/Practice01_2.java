package com.javaex.practice;

import java.util.Scanner;

public class Practice01_2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		p6(); System.out.println();
//		p7(); System.out.println();
		p8(); System.out.println();
//		p9(); System.out.println();
//		p10(); System.out.println();
		
	}
	
	private static void p6() {
		// 입력 값 홀수 -> 입력 값까지의 홀수 합
		// 입력 값 짝수 -> 입력 값까지의 짝수 합
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int n = sc.nextInt();	//sc.close();
		int sum = 0;
		
		while(n > 0) {
			sum += n;
			n = n-2;
		}
		System.out.println(sum);	
	}
	
	private static void p7() {
		Scanner sc = new Scanner(System.in);
		int ans = (int) (Math.random()*100 + 1);
		System.out.println("==============숫자맞추기 게임 시작==============");
		while(true) {
			System.out.printf(">>");
			int tmp = sc.nextInt();
			if (ans > tmp) System.out.println("더 높게");
			else if (ans < tmp) System.out.println("더 낮게");
			else {
				System.out.println("맞았습니다");
				System.out.printf("게임을 종료하시겠습니까?(y/n) >>");
				String res = sc.next();
				if (res.equals("y")) break;
				else continue;
			}
		}
	}
	
	private static void p8() {
		Scanner sc = new Scanner(System.in);
		int choose = 0, income = 0, outcome = 0, now = 0;
		bank : while(true) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.printf("선택>"); choose = sc.nextInt();
			
			switch (choose) {
				case 1 : 
					System.out.printf("예금액>"); income = sc.nextInt();
					now += income;
					break;
				case 2 :
					System.out.printf("출금액>"); outcome = sc.nextInt();
					now -= outcome;
					break;
				case 3 :
					System.out.printf("잔고액>");
					System.out.println(now);
					break;
				case 4 :
					System.out.println("프로그램종료");
					break bank;
				default :
					System.out.println("다시입력해주세요");
					
			}
			
			
			
		}
	}

}
