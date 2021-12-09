
public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First aa = new First();
		First bb = new First(10);
		First cc = new First(20, 3);

		System.out.println(aa.getA() + "\t" + aa.getB());
		System.out.println(bb.getA() + "\t" + bb.getB());
		System.out.println(cc.getA() + "\t" + cc.getB());
	}

	int a, b;

	public First() {
		// a = b = 0;
		this(0, 0);
	}

	public First(int a) {
		// this.a = a;
		this(a, 0);
	}

	public First(int a, int b) {
		this.a = a;
		this.b = b;
	}

	private String getA() {
		return String.format("%d", a);
	}

	private String getB() {
		return String.format("%d", b);
	}

}
