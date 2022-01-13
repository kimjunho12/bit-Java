package prob4;

public class SoundTest {

	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
		printSound(new Sparrow());
		printSound(new Duck());
	}

	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}

	private static class Cat implements Soundable {

		@Override
		public String sound() {
			return "야옹";
		}
	}

	private static class Dog implements Soundable {

		@Override
		public String sound() {
			return "멍멍";
		}
	}

	private static class Sparrow implements Soundable {

		@Override
		public String sound() {
			return "짹짹";
		}
	}

	private static class Duck implements Soundable {

		@Override
		public String sound() {
			return "꽥꽥";
		}
	}
}