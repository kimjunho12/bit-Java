package com.javaex.api.stringclass;

import java.util.Arrays;

public class StringEx {

	public static void main(String[] args) {
//		usefulMethods();
		stringBufferEx();
	}
	
	private static void stringBufferEx() {
		// 버퍼의 생성
		StringBuffer sb = new StringBuffer("Tbis");
		System.out.println(sb);						// This
				
		// 문자열 추가 : append
		sb.append(" is pencil");
		System.out.println(sb);						// This is pencil
		
		// 문자열 삽입 : insert
		sb.insert(7, " my");						// 7번 인덱스에 " my"를 추가
		System.out.println(sb);						// This my is pencil
		
		// 문자열 치환 : replace
		sb.replace(7, 10, " your");					// 7번부터 10번 앞까지를 " your"로 변경
		System.out.println(sb);						// This your is pencil
		
		// 버퍼사이즈 조정 : setLength
		sb.setLength(6);
		System.out.println(sb);						// This i
		
		// 위와 동일하지만 체이닝한 방법
		StringBuffer sb2 = new StringBuffer("This").append(" is pencil").insert(7, " my").replace(7, 10, " your");
		String s = sb2.toString();					// 문자열 생성
		System.out.println(s);
	}

	private static void usefulMethods() {
		// 유용한 메서드들
		String str = "Java Programming JavaScript Programming";
		
		System.out.println("str : " + str);					// str : Java Programming JavaScript Programming
		System.out.println("LENGTH : " + str.length());		// LENGTH : 39
		
		// 변환 메서드
		System.out.println("UPPER : " + str.toUpperCase()); // UPPER : JAVA PROGRAMMING JAVASCRIPT PROGRAMMING
		System.out.println("LOWER : " + str.toLowerCase());	// LOWER : java programming javascript programming
		
		// 검색 메서드
		System.out.println("인덱스 5의 글자 : " + str.charAt(5));				// 인덱스 5의 글자 : P
		int index = str.indexOf("Java");									// "Java"의 인덱스
		System.out.println("1번째 Java 인덱스 : " + index);					// 1번째 Java 인덱스 : 0
		index = str.indexOf("Java", 5);										// 5번 인덱스 이후의 "Java"
		System.out.println("2번째 Java 인덱스 : " + index);					// 2번째 Java 인덱스 : 17
		index = str.indexOf("Java", 21);									// 21번 인덱스 이후의 "Java"
		System.out.println("3번째 Java 인덱스 : " + index);					// 3번째 Java 인덱스 : -1 // -1 : 찾을 수 없음
		
		System.out.println("마지막 Java 인덱스 : " + str.lastIndexOf("Java"));	// 마지막 Java 인덱스 : 17
		
		// 문자열 추출
		System.out.println("substring(5) : " + str.substring(5));			// substring(5) : Programming JavaScript Programming // 5부터 전체
		System.out.println("substring(5, 16) : " + str.substring(5, 16));	// substring(5, 16) : Programming		// 5 ~ 16 앞까지
		
		// 문자열 변경
		System.out.println("replace : " + str.replace("Programming", "Coding"));	// replace : Java Coding JavaScript Coding
		
		// 문자열은 변경되지 않음 (새로운 문자열이 생성되는 것)
		System.out.println("str : " + str);					// str : Java Programming JavaScript Programming
		
		// 화이트 스페이스 (공백문자, 개행문자, 탭문자 등) 제거 .trim()
		String s2 = "           Hello      ";
		String s3 = "      Java           ";
		System.out.println(s2.trim() + " " + s3.trim());	// Hello Java
		
		// 문자열 분리	.split(구분자) -> 구분자로 잘라서 배열로 반환
		String[] words = str.split(" ");
		System.out.println(Arrays.toString(words));			// [Java, Programming, JavaScript, Programming]
		for (String word : words) {
			System.out.println("WORD : " + word);
		}
		
		// 문자열 비교 : Unicode 비교
		// 0 : 순서가 같다		음수 : 전자가 후자보다 순서가 빠르다		양수 : 순서가 늦다
		System.out.println("ABC".compareTo("ABD"));			// -1		
	}
}
