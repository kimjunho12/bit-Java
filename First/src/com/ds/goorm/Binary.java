package com.ds.goorm;

import java.io.*;

public class Binary {
    static int n, target;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		n = Integer.valueOf(input);
		
		input = br.readLine();		
		String[] inputArr = input.split(" ");
		arr = new int[n];
		for (int i = 1; i < n; ++i){
			arr[i] = Integer.valueOf(inputArr[i]);
		}
		
		target = Integer.valueOf(br.readLine());
		
		int result = bSearch(0, n-1);
		System.out.println(result > 0 ? result + 1 : "X");
	}
	
	private static int bSearch(int start, int end) {
		int mid;
		if(start <= end) {
			mid = (start + end) / 2;
			// 값을 바로 찾았을 경우
			if(target == arr[mid]) {
				return mid;
			} else if(target < arr[mid]) {		// 중앙값보다 작을 경우
				return bSearch(start, mid-1);	// 왼쪽에서 탐색
			} else {							// 중앙값보다 클 경우
				return bSearch(mid+1, end); 	// 오른쪽에서 탐색
			}
		}
		return -1;
	}
}
