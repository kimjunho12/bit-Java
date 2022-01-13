package prob5;

public class MyStack {
	String[] stack;
	int top;
	
	public MyStack() {}
	
	public MyStack(int n) {
		stack = new String[n];
		this.top = -1;
	}
	
	public void push(String s) throws MyStackException {
		if (top == stack.length)
			throw new MyStackException("stack is overflow");
		stack[++top] = s;
	}
	
	public String pop() throws MyStackException {
		if(top < 0)
			throw new MyStackException("stack is empty");
		return stack[top--];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
}