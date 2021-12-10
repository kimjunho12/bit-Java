package com.ds.goorm;

import java.util.Scanner;

public class StainAlg {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		int a = 0, b = 0;

		int num1 = Integer.valueOf(input.split(" ")[0]);
		int num2 = Integer.valueOf(input.split(" ")[1]);

		while (true) {
			System.out.println(a + " " + b);
			if (num1 % 2 == 0 && num2 % 2 == 0) {
				num1 /= 2;
				num2 /= 2;
				a++;
			} else if (num1 % 2 == 0 && num2 % 2 == 1) {
				num1 /= 2;
			} else if (num1 % 2 == 1 && num2 % 2 == 0) {
				num2 /= 2;
			} else if (num1 % 2 == 1 && num2 % 2 == 1) {
				if (num1 < num2) {
					num2 = num2 - num1;
					b = num2;
				} else if (num1 > num2) {
					num1 = num1 - num2;
					b = num1;
				} else{
					b = num1;
					break;
				}
			}
		}
		System.out.println((int) Math.pow(2, a) * b);
	}

}
