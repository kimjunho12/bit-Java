package com.javaex.oop.goods.v2;

public class GoodsAPP {

	public static void main(String[] args) {
		Goods notebook = new Goods();
		notebook.setName("Macbook Air");
		notebook.setPrice(1600000);
		
		Goods smartphone = new Goods();
		smartphone.setName("iPhone 13");
		smartphone.setPrice(1000000);

		System.out.printf("%s, %d원%n", notebook.getName(), notebook.getPrice());
		System.out.printf("%s, %d원%n", smartphone.getName(), smartphone.getPrice());
		
		notebook.showInfo();
		smartphone.showInfo();
	}

}
