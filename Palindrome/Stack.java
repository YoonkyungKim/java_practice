public class Stack {
	private int top;
	private char[] charStack;
	
	//one-argument constructor
	public Stack(int size) {
		if (size < 0) {
			System.out.println("size must be positive number");
		} else {
			top = -1;
			charStack = new char[size];
		}
	}
	
	//push method
	public void push(char input) {
		charStack[++top] = input;
	}
	
	//pop method
	public char pop() {
		return charStack[top--];
	}
}
