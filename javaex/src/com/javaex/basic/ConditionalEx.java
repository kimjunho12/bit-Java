package com.javaex.basic;

import java.util.Scanner;

public class ConditionalEx {

	public static void main(String[] args) {
//		ifElseEx();
//		ifElseEx2();
//		switchEx();
		switchEx2("MON");
	}
	
	private static void switchEx2(String day) {
		String message;
		
		switch(day) {
		case "MON":
		case "TUE":
		case "WED":
		case "THU":
			message = "열공";
			break;
		case "FRI":
			message = "열공 후 불금";
			break;
		case "SAT":
		case "SUN":
			message = "주말";
			break;
		default:
			message = "?";
		}
		
		System.out.println(day + "에는 " + message);
		
	}
	private static void switchEx() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("과목을 선택하세요.");
		System.out.println("1.Java, 2.C, 3.C++, 4.Python");
		
		int code = scanner.nextInt();
		
		switch(code) {
		case 1:	//	if (code == 1) 
			System.out.println("R101");
			break;
		case 2:	//	else if (code == 2)
			System.out.println("R202");
			break;
		case 3:	//	else if (code == 3)
			System.out.println("R303");
			break;
		case 4:	//	else if (code == 4)
			System.out.println("R404");
			break;
		default:
			System.out.println("상담원 문의");
		}
		scanner.close();
	}
	
	private static void ifElseEx2() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("과목을 선택하세요.");
		System.out.println("1.Java, 2.C, 3.C++, 4.Python");
		
		int code = scanner.nextInt();
		
		if (code == 1) {
			System.out.println("R101");
		} else if (code == 2) {
			System.out.println("R202");
		} else if (code == 3) {
			System.out.println("R303");
		} else if (code == 4) {
			System.out.println("R404");
		} else { //	나머지
			System.out.println("상담원 문의");
		}
		
		scanner.close();
	}
	//	if문 연습
	private static void ifElseEx() {
		Scanner scanner = new Scanner(System.in);
		
		//	if ~ else if ~ else
		System.out.print("정수입력:");
		int num = scanner.nextInt();
		
//		if (num > 0) {
//			System.out.println(num + "는 양수입니다.");
//		} else if (num < 0) {
//			System.out.println(num + "는 음수입니다.");	
//		} else {
//			System.out.println("0입니다");
//		}
		
		//	중첩 if 
		if (num == 0) {
			System.out.println("0입니다");
		} else {	//	양수 or 음수
			if (num > 0) {
				System.out.println(num + "는 양수입니다.");
			} else {
				System.out.println(num + "는 음수입니다.");
			}
		}
		
		scanner.close();
	}

}