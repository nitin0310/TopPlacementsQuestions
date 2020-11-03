package question9;
import java.util.*;
import java.io.*;

public class MainClass {
	
	//O(n) --time			O(n) --space(stack)
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String expression=br.readLine();
		System.out.println(checkValid(expression));
	}
	
	static int checkValid(String exp) {
		if(exp.length()==0) {
			return 0;
		}
		
		Stack<Character> stack=new Stack<Character>();
		
		int count=0;
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			
			if(ch==')' && !stack.isEmpty()) {
				if(stack.peek()=='(') {
					count=count+2;
					stack.pop();
				}
				else {
					stack.push(ch);
				}
			}else {
				stack.push(ch);
			}
			
		}
		return count;
	}
	
}
