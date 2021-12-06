package com.javaex.oop.staticmember;

public class StaticExApp {

	public static void main(String[] args) {
		System.out.println("RefCount:" + StaticEx.refCount);
		StaticEx s1 = new StaticEx();
		// static 멤버는 new없이 접근 가능
		System.out.println("RefCount:" + StaticEx.refCount);
		

		StaticEx s2 = new StaticEx();
		System.out.println("RefCount:" + StaticEx.refCount);
		
		s2 = null;		// s2 해제
		System.out.println("s2 해제");
		System.out.println("RefCount: "+StaticEx.refCount);
		
		// ! 주의 : 가비지 컬렉터를 직접 호출하지 않는다
		System.gc();
		try {
			Thread.sleep(3000);
			System.out.println("RefCount: "+StaticEx.refCount);
		} catch (Exception e) {
			
		}
	}

}
