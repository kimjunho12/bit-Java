package com.javaex.oop.casting;

public class AnimalApp {

	public static void main(String[] args) {
		// Up casting / Down casting
		Dog dog1 = new Dog("스누피");
		dog1.eat();
		dog1.walk();
		dog1.bark();
		
		Animal dog2 = new Dog("아지");		// Up casting : 참조 자료형에 있는 설계된 멤버에만 접근 가능
		dog2.eat();
		dog2.walk();
		
		((Dog) dog2).bark();
		
		Animal cat1 = new Cat("야옹이");		// Up casting
		cat1.eat();
		cat1.walk();
		
		if (cat1 instanceof Dog)
			((Dog) cat1).bark();
		else if (cat1 instanceof Cat)
			((Cat) cat1).meow();
		
//		Dog[] pets = new Dog[3];
		Animal[] pets = new Animal[3];
		pets[0] = dog1;
		pets[1] = (Dog) dog2;
		pets[2] = new Dog("멍멍이");
		
		pets[2] = new Cat("아즈라엘");
		
		for (Animal pet : pets) {
			pet.eat();
			pet.walk();
			
			if (pet instanceof Dog)
				((Dog) pet).bark();
			else if (pet instanceof Cat)
				((Cat) pet).meow();
			
		}
	}

}
