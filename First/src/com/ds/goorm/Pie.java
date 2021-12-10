package com.ds.goorm;

import java.io.*;

// 미제출
public class Pie {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		final String PIE = "3.14159265358979323846";			// π 값 저장
		int pieLen = Integer.valueOf(input);
		
		
		System.out.print(String.valueOf(PIE.toCharArray(), 0, 2+pieLen));	// 소숫점 자리수와 3.을 위한 2자리 추가 후 출력
	}
}