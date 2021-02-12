public class Palindrome {

	public static void main(String[] args) {
		
		//If there's any command line argument given,
		if (args.length > 0) {
			for (String str : args) {
				
				//To make a Palindrome case insensitive, change String to lower case
				String lowerStr = str.toLowerCase();
				
				//Since we use char array in Stack,
				//Change received String to char array
				char[] input = lowerStr.toCharArray();

				//Get the input length
				int inputLen = input.length;

				//Find the mid point
				int mid = inputLen / 2;

				//Declare and initialize Stack object with size mid
				Stack stack = new Stack(mid);

				//Iterator
				int i = 0;

				//Push each character of input to Stack until the mid point
				while (i < mid) {
					stack.push(input[i]);
					i++;
				}

				// If the input's length is odd, ignore the mid character
				if (inputLen % 2 != 0) {
					i++;
				}

				boolean isPalindrome = true;

				//Pop each character from the stack
				//If popped value is not equal to the ith element, input is not a palindrome
				while (isPalindrome == true && i < inputLen) {
					char elem = stack.pop();
					if (elem != input[i]) {
						isPalindrome = false;
					}
					i++;
				}
				
				//Display the output based on the result
				if (isPalindrome) {
					System.out.println(str + " is a palindrome.");
				} else {
					System.out.println(str + " is not a palindrome.");
				}
			}
			
		//If there's no command line arguments,
		} else {
			System.out.println("Please enter command line arguments.");
		}
	}

}
