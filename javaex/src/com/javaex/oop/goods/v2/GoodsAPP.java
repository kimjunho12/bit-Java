package com.javaex.oop.goods.v2;

public class GoodsAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods notebook = new Goods();
		notebook.name = "Macbook Air";
		notebook.price = 1600000;
		
		Goods smartphone = new Goods();
		smartphone.name = "iPhone 13";
		smartphone.price = 1000000;

		System.out.printf("%s, %d원%n", notebook.name, notebook.price);
		System.out.printf("%s, %d원%n", smartphone.name, smartphone.price);
	}

}
