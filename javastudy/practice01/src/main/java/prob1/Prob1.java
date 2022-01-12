package prob1;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int num = 0;
		
		System.out.print("수를 입력하시오 : "); num = scanner.nextInt();
		System.out.println(num % 3 == 0 ? "3의 배수입니다." : "3의 배수가 아닙니다.");
		
		scanner.close();
	}
}
