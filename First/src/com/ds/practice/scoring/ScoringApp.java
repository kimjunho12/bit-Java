package com.ds.practice.scoring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 성적 처리 프로그램
 * 1. 삽입 (이름, 국, 영, 수)
 * 2. 검색 (이름, 성적)
 * 3. 삭제
 * 4. 출력
 */

public class ScoringApp {
	private static Set<Score> studentSet = new HashSet<>();
	private static Map<Integer, Score> studentMap = new HashMap<>();
	private static LinkedList<Score> studentList = new LinkedList<>();

	public static void main(String[] args) {
		System.out.println("=================================== 성적 처리 프로그램 ===================================");
		P: while (true) {
			int choose = choice();
			switch (choose) {
				case 1:
					System.out.print("성적 정보를 입력 하세요.\n");
					studentList.add(Score.inputScore());
					break;
				case 2:
					System.out.print("검색할 학생명을 입력 하세요.\n>> ");
					Score.searchInfo(studentList);
					break;
				case 3:
					System.out.print("삭제할 학생명을 입력 하세요.\n>> ");
					studentList.remove(
							Score.remove(studentList));
					break;
				case 4:
					System.out.println("======================================= 전체 성적 =======================================");
					Score.printAll(studentList);
					break;
				default:
					break P;
			} // End of switch
			System.out.println("=========================================================================================");
		} // End of while
	} // End of main

	private static int choice() {
		int choose;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("1. 삽입 \t 2. 검색 \t 3. 삭제 \t 4. 출력\n>> ");
			choose = sc.nextInt();				
		} catch (Exception e) {
			//TODO: handle exception
			System.err.println("정확한 값을 입력하세요.");
			return choice();	// 재귀 호출로 다시 입력 시작
		}
		return choose;
	}

} // End of Class
