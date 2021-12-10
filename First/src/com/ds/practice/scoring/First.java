package com.ds.practice.scoring;

import java.util.Scanner;
import java.util.Set;

/*
 * 성적처리프로그램
 * 1. 입력 ( 이름, 국, 영, 수 )
 * 2. 검색 ( 이름검색, 평균검색 (50점이상) (평균이 50점 이상인 사람 출력) )
 * 3. 출력 ( 전체출력 )
 */

/*
 * 1. 삽입 (이름, 국, 영, 수)
 * 2. 검색 (이름, 성적)
 * 3. 삭제
 * 4. 출력
 */

public class First {
	private static Score[] students;

	public static void main(String[] args) {
		First f = new First();
		int n;

		// 입력
		Scanner sc = new Scanner(System.in);
		try {
			System.out.printf("입력 할 학생 수를 입력 하세요 : "); n = sc.nextInt();
			students = new Score[n];
			for (int i = 0; i < n; ++i) {
				students[i] = f.inputScore();
			}
		} catch (Exception e) {
			System.err.println("정확한 숫자를 입력 해 주세요");
			return ;
		}

		// 검색
		f.searchInfo();
		f.searchAvg();

		// 전체 출력
		f.printAll();

	}

	public class Score {
		String name;
		int ko, en, math;

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
	}

	private Score inputScore() {
		String name;
		int ko, en, math;

		Scanner sc = new Scanner(System.in);
		System.out.printf("이름을 입력하세요 : ");		name = sc.next();
		System.out.printf("국어 성적을 입력하세요 : ");	ko = sc.nextInt();
		System.out.printf("영어 성적을 입력하세요 : ");	en = sc.nextInt();
		System.out.printf("수학 성적을 입력하세요 : ");	math = sc.nextInt();
		System.out.println();

		Score info = new Score(name, ko, en, math);
		return info;
	}

	private void searchInfo() {
		String inputName;
		Scanner sc = new Scanner(System.in);
		System.out.printf("검색 할 이름을 입력하세요 : ");
		inputName = sc.next();
		
		for (Score s : students) {
			if (s.name.equals(inputName))
				System.out.println(s.toString());
		}
		System.out.println();
	}

	private void searchAvg() {
		String s = "";
		System.out.printf("평균 50점을 넘긴 사람은 ");
		for (int i = 0; i < students.length; ++i) {
			double avg = (students[i].ko + students[i].en + students[i].math) / 3;
			if (avg >= 50)
				 s += String.format("%s ", students[i].name);
		}
		if (s.isEmpty()) 
			System.out.println("없습니다.\n");
		else
			System.out.println(s + "입니다.\n");

	}

	private void printAll() {
		System.out.println("---------------전체 성적----------------");
		for (int i = 0; i < students.length; ++i) {
			System.out.println(students[i].toString());
		}
	}
}
