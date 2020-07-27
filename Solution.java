import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);		
		//String exp = "[$]]";
		String exp = scn.next();
		if(!exp.isEmpty()) {
		System.out.println(exp + " is valid expression: " + isValidateExpression(exp));
		}else {
			System.out.println("Invalid Input");	
		}
	}

	public static boolean isValidateExpression(String exp) {
		if (exp == null || exp.trim().equalsIgnoreCase("")) {
			return true;
		}
		Stack<Character> charStack = new Stack<>();
		Stack<Character> jokerStack = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			if (c == '[') {
				charStack.push(c);
			} else if (c == ']') {
				if (!charStack.isEmpty() && charStack.peek() == '[') {
					charStack.pop();
				} else if (!jokerStack.isEmpty()) {
					jokerStack.pop();
				} else {
					// System.out.printf("Invalid expression");
					return false;
				}
			} else if (c == '$') {
				jokerStack.push(c);
			}
		}
		if (charStack.isEmpty()) {
			// System.out.printf("Valid expression");
			return true;
		} else {
			if (charStack.size() <= jokerStack.size()) {
				return true;
			}
			return false;
		}
	}
}