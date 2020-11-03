package question25;
import java.io.*;
import java.util.*;

public class UsingStacks {
	//O(n) --time 				O(n) --space
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter substring : ");
		String expr=br.readLine();
		
		findValidSubstring(expr);
	}
	
	static void findValidSubstring(String expr) {
		if(expr.length()<=1) {
			System.out.println(0);
		}else {
			Stack<Character> stack=new Stack<Character>();
			int countOfValidSubString=0;
			
			for(int i=0;i<expr.length();i++) {
				char ch=expr.charAt(i);
				
				if(ch==')') {
					if(!stack.isEmpty() && stack.peek()=='(') {
						countOfValidSubString++;
						stack.pop();
					}else {
						stack.push(ch);
					}
				}else{
					stack.push(ch);
				}
			}
			System.out.println(countOfValidSubString);
		}
	}
}
