package com.javaex.basic;

public class EnumEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		enumEX();
//		enumEX2("SUN");
		enumEX3(Week.FRI);
		
	}
	
	private static void enumEX3(Week day) {
		String message;
		
		switch (day) {
		case MON :
		case TUE :
		case WED :
		case THU :
			message = "열공";
			break;
		case FRI :
			message = "열공 후 불금";
			break;
		case SAT :
		case SUN :
			message = "주말";
			break;
		default : 
			message = "?";
		}
		
		System.out.printf("%s에는 %s%n", day.name(), message);		
	}
	
	private static void enumEX() {
		Week today = Week.FRI;
		System.out.printf("Today is %s(%d)%n", today.name(), today.ordinal());
				
	}
	
	private static void enumEX2(String day) {
		// 문자열을 열거 상수를 반환
		Week obj = Week.valueOf(day);
		System.out.printf("%s is %s(%d)%n",
				day,
				obj.name(),
				obj.ordinal());

		Week today = Week.FRI;
		System.out.println("FRI SUN의 순번차 : " + today.compareTo(obj));
	}
}
