package com.ds.practice.scoring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Score {
	private String name;
	private int ko, en, math;

	public Score() {

	}

	public Score(String name, int ko, int en, int math) {
		this.name = name;
		this.ko = ko;
		this.en = en;
		this.math = math;
	}

	@Override
	public String toString() {
		return "Score [name=" + name + ", ko=" + ko + ", en=" + en + ", math=" + math + "]";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKo() {
		return ko;
	}

	public void setKo(int ko) {
		this.ko = ko;
	}

	public int getEn() {
		return en;
	}

	public void setEn(int en) {
		this.en = en;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}



	public static Score inputScore() {
		Scanner sc = new Scanner(System.in);
		String name = null;
		int ko, en, math;
		ko = en = math = 0;
		try {	
			System.out.printf("이름을 입력하세요 : ");		name = sc.next();
			System.out.printf("국어 성적을 입력하세요 : ");	ko = sc.nextInt();
			System.out.printf("영어 성적을 입력하세요 : ");	en = sc.nextInt();
			System.out.printf("수학 성적을 입력하세요 : ");	math = sc.nextInt();
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println("정확한 값을 입력 해 주세요.");
			return inputScore();	// 재귀 호출로 다시 입력 시작
		}			

		Score info = new Score(name, ko, en, math);
		return info;
	}

	public static <T> void searchInfo(T students) {
		String inputName = getInputName();
		Iterator<Score> it = getIterator(students);

		boolean searchCheck = false;
		while(it.hasNext()) {
			Score s = it.next();
			if (s.getName().equals(inputName)){
				System.out.println(s.toString());
				searchCheck = true;
			}
		}
		if (!searchCheck)
			System.out.println("정보가 없습니다.");
	}

	public static <T> Score remove(T students){
		String inputName = getInputName();
		Iterator<Score> it = getIterator(students);
		
		boolean searchCheck = false;
		Score result = null;
		while(it.hasNext()) {
			Score s = it.next();
			if (s.getName().equals(inputName)) {
				result = s;
				searchCheck = true;
			}
		}
		if (!searchCheck) {
			System.out.println("정보가 없습니다.");
		} else {
			System.out.println("삭제 되었습니다.");
		}
		return result;
	}

	public static <T> void printAll(T students) {
		Iterator<Score> it = getIterator(students);
		while(it.hasNext()) {
			Score s = it.next();
			System.out.println(s.toString());
		}
	}

	private static String getInputName(){
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private static <T> Iterator<Score> getIterator(T students) {
		Iterator<Score> it;

		if (students instanceof HashSet) {
			it = ((HashSet) students).iterator();
		} else if (students instanceof HashMap) {
			it = ((HashMap) students).values().iterator();
		} else if (students instanceof LinkedList) {
			it = ((LinkedList) students).iterator();
		} else {
			it = new Iterator<Score>() {

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public Score next() {
					// TODO Auto-generated method stub
					return null;
				}
				
			};
		}
		return it;
	}
	
	// private void searchAvg() {
	// 	String s = "";
	// 	System.out.printf("평균 50점을 넘긴 사람은 ");
	// 	for (int i = 0; i < students.length; ++i) {
	// 		double avg = (students[i].ko + students[i].en + students[i].math) / 3;
	// 		if (avg >= 50)
	// 			 s += String.format("%s ", students[i].name);
	// 	}
	// 	if (s.isEmpty()) 
	// 		System.out.println("없습니다.\n");
	// 	else
	// 		System.out.println(s + "입니다.\n");
	// }
}
