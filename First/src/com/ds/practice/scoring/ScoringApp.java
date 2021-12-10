package com.ds.practice.scoring;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


/**
 * 성적 처리 프로그램
 * 1. 삽입 (이름, 국, 영, 수)
 * 2. 검색 (이름, 성적)
 * 3. 삭제
 * 4. 출력
 */

public class ScoringApp {
	private static Collection studentC;
	private static Map<Integer, Score> studentM;

	public static void main(String[] args) {
		System.out.println("=================================== 성적 처리 프로그램 ===================================");
		choiceType();		
	} // End of main

	private static void choiceType() {
		int choose = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("데이터 타입을 선택하세요.");
			System.out.print("1. Set \t\t 2. Map \t 3. List \n>> ");
			choose = sc.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("정확한 값을 입력하세요.");
			choiceType(); // 재귀 호출로 다시 입력 시작
		}
		switch (choose) {
			case 1:
				studentC = new HashSet<Score>();
				start(studentC);
				break;
			case 2:
				studentM = new HashMap<Integer, Score>();
				start(studentM);
				break;
			case 3:
				studentC = new LinkedList<Score>();
				start(studentC);
				break;
			default:
				studentC = new HashSet<Score>();
				start(studentC);
		}
	} // End of choiceType

	private static int choice() {
		int choose;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("1. 삽입 \t 2. 검색 \t 3. 삭제 \t 4. 출력\n>> ");
			choose = sc.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("정확한 값을 입력하세요.");
			return choice(); // 재귀 호출로 다시 입력 시작
		}
		return choose;
	} // End of choice

	private static void start(Collection c){
		P: while (true) {
			int choose = choice();
			switch (choose) {
				case 1:
					System.out.print("성적 정보를 입력 하세요.\n");
					c.add(Score.inputScore());
					break;
				case 2:
					System.out.print("검색할 학생명을 입력 하세요.\n>> ");
					Score.searchInfo(c);
					break;
				case 3:
					System.out.print("삭제할 학생명을 입력 하세요.\n>> ");
					c.remove(Score.getRemoveItem(c));
					break;
				case 4:
					System.out.println(
							"======================================= 전체 성적 =======================================");
					Score.printAll(c);
					break;
				default:
					break P;
			} // End of switch
			System.out.println(
					"=========================================================================================");
		} // End of while
	} // End of start

	private static void start(Map<Integer, Score> m){
		P: while (true) {
			int choose = choice();
			switch (choose) {
				case 1:
					System.out.print("성적 정보를 입력 하세요.\n");
					Score s = Score.inputScore();
					m.put(s.hashCode(), s);
					break;
				case 2:
					System.out.print("검색할 학생명을 입력 하세요.\n>> ");
					Score.searchInfo(m);
					break;
				case 3:
					System.out.print("삭제할 학생명을 입력 하세요.\n>> ");
					Score ss = Score.getRemoveItem(m);
					m.remove(ss.hashCode(), ss);
					break;
				case 4:
					System.out.println(
							"======================================= 전체 성적 =======================================");
					Score.printAll(m);
					break;
				default:
					break P;
			} // End of switch
			System.out.println(
					"=========================================================================================");
		} // End of while
	} // End of start
} // End of Class
