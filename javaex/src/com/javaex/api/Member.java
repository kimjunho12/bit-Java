package com.javaex.api;

public class Member implements Comparable {
	String name;
	
	public Member(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + "]";
	}

	@Override
	public int compareTo(Object o) {
		// 0 : 두 객체 순번 같음	음수 : 순서가 앞이다		양수 : 순서가 뒤다
		if (o instanceof Member) {
			Member other = (Member) o;
			return name.compareTo(other.name);
		}
		return 0;
	}
}
