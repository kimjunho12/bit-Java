package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num, result;
		num = result = 0;
		System.out.print("숫자를 입력하세요: "); num = scanner.nextInt();
		while(num > 0) {
			result += num;
			num -= 2;
		}
		System.out.println("결과 값 : " + result);
		
		scanner.close();
	}
}
