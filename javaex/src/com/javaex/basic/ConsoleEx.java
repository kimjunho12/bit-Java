package com.javaex.basic;

import java.util.Scanner;

public class ConsoleEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		consoleOutputEX();
//		consoleInputEX();
		
	}
	// 콘솔 입력
	private static void consoleInputEX() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름은?");
		String name = scanner.next();
		System.out.print("나이는?");
		int age = scanner.nextInt();
		
		System.out.println("당신의 나이는 " + age + ", 이름은 " + name + "입니다.");
		scanner.close(); 		// 항상 닫아주자
		
		String rawString = "문자열로 이루어진 스캐너 테스트";
		scanner = new Scanner(rawString);
		String s1, s2, s3;
		s1 = scanner.next();
		s2 = scanner.next();
		s3 = scanner.nextLine();
		
		System.out.println(s1 + s2 + s3);
		
		scanner.close(); 		// 항상 닫아주자
	}
	
	// 콘솔 출력
	private static void consoleOutputEX() {
		// System.out.print : 개행 안함
		// System.out.println : 개행 함
		// System.out.printf : 형식 지정 문자열 출력; -> String.format
		
		System.out.print("Hello ");		// 개행 x
		System.out.println("Java"); 	// 개행 o
		
		// 이스케이프 문자
		// \n(개행), \t(탭), \" \'(따옴표), \\(역슬래시 \ )
		
		System.out.println("Hello\n Java");			// 개행
		System.out.println("Hello\t Java");			// 탭
		System.out.println("Hello \"Java\"");		// 따옴표
		
		String dir = "C:\\Users\\Bit\\Desktop";		// 역슬래시
		System.out.println(dir);
		
	}
	
	private void consoleInEX() {
		
	}

}
