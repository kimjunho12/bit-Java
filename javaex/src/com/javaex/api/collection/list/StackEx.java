package com.javaex.api.collection.list;

import java.util.Stack;

public class StackEx {

	public static void main(String[] args) {
		// 스택 선언
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i <= 10; ++i) {
			// push
			stack.push(i);
			System.out.println("STACK : " + stack);
		}
		
		// 가장 위 데이터 확인 : peek
		System.out.println("Peek : " + stack.peek());
		System.out.println("STACK : " + stack);
		
		// 인출 : pop
		System.out.println("POP : " + stack.pop());
		System.out.println("STACK : " + stack);
		
		while(!stack.isEmpty()) {		// 인출 전 비어있는지 체크
			System.out.println("POP : " + stack.pop());
			System.out.println("STACK : " + stack);
		}
		
	}

}
