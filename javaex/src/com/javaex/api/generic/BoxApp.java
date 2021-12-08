package com.javaex.api.generic;

public class BoxApp {

	public static void main(String[] args) {
		IntBox iBox = new IntBox();
		iBox.setContent(10);
		System.out.println("IntBox : " + iBox.getContent());
		
		StrBox sBox = new StrBox();
		sBox.setContent("String");
		System.out.println("StrBox : " + sBox.getContent());
		
		ObjBox oBox = new ObjBox();
		oBox.setContent(10);
		oBox.setContent("String");
		
		String value = (String) oBox.getContent();
		System.out.println("content : " + value);
//		int iValue = (Integer) oBox.getContent();
	}

}
