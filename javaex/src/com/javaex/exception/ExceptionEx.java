package com.javaex.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

	public static void main(String[] args) {
		arithExceptionEx();

	}

	private static void arithExceptionEx() {
		double result = 0;
		int num;
		
		Scanner scanner = new Scanner(System.in);
		System.out.printf("정수 입력 : ");
		
		try {
			// 예외박생 가능 영역
			num = scanner.nextInt();
			result = 100/num;
			
		} catch (InputMismatchException e) {
			System.err.println("정수로 해 주세요");
		}
		catch(ArithmeticException e) {
			System.err.println("0으로는 나눌 수 없어요");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {			// 예외 유무 관계없이 가장 마지막에		(시스템 자원 정리 작업에 활용됨)
			System.out.println("예외 처리 종료");
		}
		
		System.out.println(result);
		scanner.close();
	}

}
