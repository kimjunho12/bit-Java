package com.ds.goorm;

import java.util.Scanner;

public class ParentWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String parent = sc.next();
		String input = sc.next();

		char[] cInput = input.toCharArray();
		boolean isContain = true;
		for (char c : cInput){
			isContain = isContain && parent.contains(String.format("%c", c));
		}

		System.out.println(isContain ? "YES" : "NO");
	}

}
