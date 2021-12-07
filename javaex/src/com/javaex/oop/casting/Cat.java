package com.javaex.oop.casting;

public class Cat extends Animal{
	public Cat(String name) {
		super(name);
	}
	
	public void meow() {
		System.out.println(name + ": 야옹!");
	}

}
