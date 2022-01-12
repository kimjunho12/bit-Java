package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < goods.length; ++i) {
			String name = scanner.next();
			int price = scanner.nextInt();
			int amount = scanner.nextInt();
			goods[i] = new Goods(name, price, amount);
		}

		// 상품 출
		for (Goods g : goods) {
			System.out.println(g);
		}

		// 자원정리
		scanner.close();
	}

	private static class Goods {
		String name;
		int price;
		int amount;

		Goods(String name, int price, int amount) {
			this.name = name;
			this.price = price;
			this.amount = amount;
		}

		@Override
		public String toString() {
			return String.format("%s(가격: %d원)이 %d개 입고 되었습니다.", name, price, amount);
		}
	}
}
