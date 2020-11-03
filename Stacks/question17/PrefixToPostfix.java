package question17;
import java.io.*;
import java.util.Stack;

public class PrefixToPostfix {
	public static void main(String args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter expression--");
		String expression=br.readLine();
		
		System.out.println(convertToPostfix(expression));
	}
	
	static String convertToPostfix(String expr) {
		int len=expr.length();
		Stack<String> stack=new Stack<String>();
		String result="";
		
		//last se scan kro
		for(int i=len-1;i>=0;i--) {
			char ch=expr.charAt(i);
			//agar operator aaye to obviously last two me koi relation hai
			//the last two le lenge and last me operator add kr denge
			if(isOperator(ch)) {
				String first=stack.pop();
				String second=stack.pop();
				
				result=first+second+ch;
				stack.push(result);
			}else {
				//operand hai to directly add kr do
				stack.push(ch+"");
			}
		}
		
		return result;
	}
	
	static boolean isOperator(char ch) {
		if(ch=='^' ||ch=='/' ||ch=='*' ||ch=='+' ||ch=='-') {
			return true;
		}
		return false;
			
	}
}
