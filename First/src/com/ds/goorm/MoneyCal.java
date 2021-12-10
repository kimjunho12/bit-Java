package com.ds.goorm;

import java.util.Scanner;
import java.util.Stack;

public class MoneyCal {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();		// 스택 선언
		
		
		for (int i = 0; i < n; ++i) {
			int tmp = sc.nextInt();				// 입력 숫자 저장
			if (tmp == 0) {						// 0일 경우 top 제거
				st.pop();
			} else {							// 0이 아닐 경우 저장
				st.push(tmp);
			}
		}
		
		int result = 0;
		for (Integer i : st) {					// stack에 남은 값 합산
			result += i;
		}
		System.out.println(result);
		sc.close();
	}

}
