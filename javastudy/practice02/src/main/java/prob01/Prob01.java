package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액: ");
		int money = scanner.nextInt();
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		int[] moneyCnt = new int[10];

		for (int i = 0; i < MONEYS.length; ++i) {
			while (money - MONEYS[i] >= 0) {
				money -= MONEYS[i];
				moneyCnt[i]++;
			}
		}

		for (int i = 0; i < MONEYS.length; ++i) {
			System.out.printf("%d원: %d개\n", MONEYS[i], moneyCnt[i]);
		}

		scanner.close();
	}
}