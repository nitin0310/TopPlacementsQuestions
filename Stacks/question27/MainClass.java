package question27;
import java.io.*;
import java.util.*;

public class MainClass {
	/*
	 we are following this concept somewhere using 0 and 1 in stack:
	 + + = +
	 + - = -
	 - + = +
	 - - = +
	*/
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the expression");
		String expr=br.readLine();
		
		concludeExpression(expr);
	}
	
	static void concludeExpression(String expr) {
		char[] result=new char[expr.length()];
		Stack<Integer> stack=new Stack<Integer>();
		int i=0,index=0;
		
		stack.push(0);
		while(i<expr.length()) {
			char ch=expr.charAt(i);
			
			if(isOperator(ch)) {
				if(ch=='-') {
					if(stack.peek()==0) {
						result[index++]=ch;
					}else {
						result[index++]='+';
					}
				}else {
					if(stack.peek()==0) {
						result[index++]=ch;
					}else {
						result[index++]='-';
					}
				}
			}else if(ch=='(') {
				if(expr.charAt(i-1)=='-') {
					if(stack.peek()==0) {
						stack.push(1);
					}else {
						stack.push(0);
					}
				}else{
					stack.push(stack.peek());
				}
			}else if(ch==')') {
				stack.pop();
			}else {
				result[index++]=ch;
			}
			i++;
		}
		
		for(int j=0;j<result.length;j++) {
			System.out.print(result[j]);
		}
	}
	
	static boolean isOperator(char ch) {
		if(ch=='+' || ch=='-') {
			return true;
		}
		return false;
	}
}
