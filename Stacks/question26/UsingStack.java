package question26;
import java.util.*;
import java.io.*;

public class UsingStack {
	//O(n^2) --time(but confused) 					O(n) --space
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter expression : ");
		String expr=br.readLine();
		checkRedundant(expr);
		
	}
	
	static void checkRedundant(String expr) {
		Stack<Character> stack=new Stack<Character>();
		
		for(int i=0;i<expr.length();i++) {
			char ch=expr.charAt(i);
			if(ch=='(' || isOperator(ch)) {
				stack.push(ch);
			}else if(ch==')') {
				if(isOperator(stack.peek())) {
					while(stack.peek()!='(') {
						stack.pop();
					}
					stack.pop();
				}else {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}
	
	static boolean isOperator(char ch) {
		if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^') {
			return true;
		}
		
		return false;
	}
	
}
