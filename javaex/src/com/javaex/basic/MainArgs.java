package com.javaex.basic;

public class MainArgs {

	public static void main(String[] args) {
		// 프로그램 실행 시 외부에서 전달되는 매게 변수들
		System.out.println("매개변수의 갯수:" + args.length);
		for (String s : args) {
			System.out.println("매개변수 :" + s);
		}
		
		System.out.println("------------------Calling ArrayEx.class------------------");
		ArrayEx.main(new String[]{"Hello", "Java", "World", "!!!!"});
	}

}
