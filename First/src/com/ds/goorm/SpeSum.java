package com.ds.goorm;

import java.io.*;

public class SpeSum {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int n = Integer.valueOf(input);
		
		input = br.readLine();
		String[] inputArr = input.split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; ++i){				// 입력 배열로 저장
			arr[i] = Integer.valueOf(inputArr[i]);
		}
		
		input = br.readLine();
		inputArr = input.split(" ");
		
		int start, end;
		start =  Integer.valueOf(inputArr[0]);		// 시작 위치
		end =  Integer.valueOf(inputArr[1]);		// 마지막 위치
		
		int result = 0;
		for (int i = start-1; i < end; ++i){		// index는 -1 씩
			result += arr[i];
		}
		
		System.out.println(result);
	}
}
