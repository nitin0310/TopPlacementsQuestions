package question6;
import java.io.*;
import java.util.*;

public class UsingStacks {
	
	//O(n) --time		O(n) --space
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		printBracketNum(str);
	}
	
	/**
	 Define a variable open = 1.
	Create a stack st.
	Now, for i = 0 to n-1.
	If exp[i] == ‘(‘, then print open, push open on to the 
	stack st and finally increment open by 1.
	
	Else if exp[i] == ‘)’, then print the top element of the stack 
	st and then pop the top element from the stack.
	
	 */
	static void printBracketNum(String exp) {
		int open=1;
		Stack<Integer> st=new Stack<Integer>();
		
		for(int i=0;i<exp.length();i++) {
			char ch=exp.charAt(i);
			
			if(ch=='(') {
				System.out.print(open);
				st.push(open);
				open++;
			}else if(ch==')') {
				System.out.print(st.pop());
			}
		}
	}
	
	
}
