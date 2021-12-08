package com.javaex.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayEx {

	public static void main(String[] args) {
//		arrayCopyEx();
//		basicSortEx();
//		basicSortDescEx();
//		custtomClassSort();
		basicSearch();
	}
	
	private static void basicSearch() {
		Integer[] scores = { 80, 50, 70, 60, 75, 88, 77 };
		System.out.println("원본 : " + Arrays.toString(scores));
		int index = Arrays.binarySearch(scores, 75);
		System.out.println("75의 인덱스 : " + index);
		
	}



	private static void custtomClassSort() {
		Member[] members = {
				new Member("홍길동"),
				new Member("고길동"),
				new Member("장길산"),
				new Member("임꺽정")
		};
		
		System.out.println("원본 : " + Arrays.toString(members));
		Arrays.sort(members);
		System.out.println("정렬 : " + Arrays.toString(members));
//		Arrays.sort(members, Collections.reverseOrder());
		Arrays.sort(members, new Comparator<Member>() {
			@Override
			public int compare(Member o1, Member o2) {
				return o1.name.compareTo(o2.name);
			}
			
		});
		System.out.println("역순정렬 : " + Arrays.toString(members));
		
	}



	private static void basicSortDescEx() {
		Integer[] scores = { 80, 50, 70, 60, 75, 88, 77 };
		System.out.println("원본 : " + Arrays.toString(scores));
		Arrays.sort(scores, Collections.reverseOrder());
		System.out.println("역순정렬 : " + Arrays.toString(scores));
	}

	private static void basicSortEx() {
		int[] scores = { 80, 50, 70, 60, 75, 88, 77 };
		System.out.println("원본 : " + Arrays.toString(scores));
		Arrays.sort(scores);	// 정렬
		System.out.println("정렬 : " + Arrays.toString(scores));
	}

	private static void arrayCopyEx() {
		int[] arr = new int[] {1,2,3,4,5,6};
		
		// System 이용 복사
		int[] target =  new int[arr.length];
		System.arraycopy(arr, 0, target, 0, arr.length);
		
		System.out.println("원본배열 : " + Arrays.toString(arr));
		System.out.println("System복제 : " + Arrays.toString(target));
		
		// Arrays 복제 메서드
		target = Arrays.copyOf(arr, arr.length);
		System.out.println("copyOf : " + Arrays.toString(target));
		
		// 배열 일부 복제
		target = Arrays.copyOfRange(
				arr,	// 원본
				1,		// 시작 인덱스
				3);		// 복사할 마지막 인덱스
		System.out.println("copyOfRange : " + Arrays.toString(target));
		
	}

}
