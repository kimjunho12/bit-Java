package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10, b = 10 - a;
		System.out.println("some code 1 ...");

		try {
			System.out.println("some code 2 ...");

			int result = (1 + 2 + 3) / b;
			
			System.out.println("some code 3 ...");
		} catch (ArithmeticException e) {
			/* 예외처리 */

			// 1. 사과
			System.out.println("아이고난!");
			// 2. 로깅
			System.err.println("error : " + e);
			// 3. 정상종료
			return;
		} finally {
			/* 자원정리 */
			System.out.println("자원 정리");
		}

	}

}