package com.ds.goorm;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class MoneyCal {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Stack<Integer> st = new Stack<>();
		
		
		for (int i = 0; i < n; ++i) {
			int tmp = sc.nextInt();
			if (tmp == 0) {
				st.pop();
			} else {
				st.push(tmp);
			}
		}
		
		int result = 0;
		for (Integer i : st){
			result += i;
		}
		System.out.println(result);
		
	}

}
