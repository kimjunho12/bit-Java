package exception;

import java.io.IOException;

public class MyClass {

	public void danger() throws IOException, MyException {
		System.out.println("some code 1 ...");
		System.out.println("some code 1 ...");

		if (5 - 5 == 0)
			throw new MyException();

		System.out.println("some code 3 ...");
		System.out.println("some code 4 ...");
	}

}
