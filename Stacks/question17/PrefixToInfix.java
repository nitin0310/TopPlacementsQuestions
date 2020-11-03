package question17;
import java.util.*;
import java.io.*;

public class PrefixToInfix {
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter expression");
		String expression=br.readLine();
		
		System.out.println(convertToInfix(expression));
	}
	
	static String convertToInfix(String expr) {
		int len=expr.length();
		Stack<String> stack=new Stack<String>();
		String result="";
		
		//last se scan kro
		for(int i=len-1;i>=0;i--) {
			char ch=expr.charAt(i);
			//agar operator aaye to obviously last two me koi relation hai
			//the last two le lenge and beech me operator add kr denge
			if(isOperator(ch)) {
				String first=stack.pop();
				String second=stack.pop();
				
				result="("+first+ch+second+")";
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
