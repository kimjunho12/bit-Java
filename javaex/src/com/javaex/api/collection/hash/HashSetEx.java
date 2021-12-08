package com.javaex.api.collection.hash;

import java.util.HashSet;

public class HashSetEx {

	public static void main(String[] args) {
		hashSetEx();

	}
	
	// Hash 알고리즘을 사용하는 컬렉션
	private static void hashSetEx() {
		HashSet<String> hs = new HashSet<>();
		
		hs.add("Java");
		hs.add("C");
		hs.add("Python");
		hs.add("Java");
				
		System.out.println(hs);
		
		// 원소의 개수
		System.out.println("hs size = " + hs.size());
		
		// 포함여부
		System.out.println("contains Java ? " + hs.contains("Java"));
		System.out.println("contains Linux ? " + hs.contains("Linux"));
		
		// 객체 삭제
		hs.remove("Python");
		System.out.println(hs);
	}

}
