package com.javaex.api.generic;

public class BoxApp {

	public static void main(String[] args) {
		IntBox iBox = new IntBox();
		iBox.setContent(10);
		System.out.println("IntBox : " + iBox.getContent());
		
		StrBox sBox = new StrBox();
		sBox.setContent("String");
		System.out.println("StrBox : " + sBox.getContent());
	}

}
