package prob5;

public class MyStackException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String cause;
	
	public MyStackException(String cause) {
		this.cause = cause;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ": " + cause;
	}

}
