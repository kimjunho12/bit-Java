package com.ds.goorm;

import java.util.Scanner;

public class ParentWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parent = sc.next();
		String input = sc.next();

		char[] cInput = input.toCharArray();		// 입력 값 char 배열로 변경
		boolean isContain = true;					// 포함 여부 확인 변수
		for (char c : cInput){						// Input의 값이
													// Parent 문자열에 c가 포함 되어있는지 확인
			isContain = isContain && parent.contains(String.format("%c", c));	// 하나라도 포함 되어있지 않으면 결과는 False로 변경
		}

		System.out.println(isContain ? "YES" : "NO");
		sc.close();
	}

}
