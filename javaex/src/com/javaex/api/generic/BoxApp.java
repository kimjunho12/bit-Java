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
		
		GenericBox<Integer> intGBox = new GenericBox<Integer>();
		// 1. 컴파일러에서 타입 체크 가능
		intGBox.setContent(10);
		// 2. 다운캐스팅 불편 해소
		Integer iValue = intGBox.getContent();
		System.out.println("content : " + iValue);
		
		GenericBox<String> strGBox = new GenericBox<>();   // 생성시에는 type 생략가능
			
	}
	
}
