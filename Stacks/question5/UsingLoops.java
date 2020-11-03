package question5;
import java.io.*;
import java.util.*;

public class UsingLoops {
	
	//simple algo --jo jo balanace hai unhe bahr fek do
	//O(n) --time
	//O(n) --space (stack)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		System.out.println(evaluateExp(str));
	}
	
	static int evaluateExp(String exp) {
		Stack<Character> stack=new Stack<Character>();
		
		int len=exp.length();
		
		if(len%2!=0) {
			System.out.println("Can't balance");
		}
		
		//remove kr dega jo directly balanced hai expression me
		for(int i=0;i<len;i++) {
			char c=exp.charAt(i);
			
			if(c==')' && !stack.isEmpty()) {
				if(stack.peek()=='(') {
					stack.pop();
				}else {
					stack.push(c);
				}
			}else {
				stack.push(c);
			}
			
		}
		int m=0,totalCount=0;
		
		Iterator itr=stack.iterator();
		//bss ab jo bache unme check kr lenge ki kitne ki kami hai
		while(itr.hasNext()) {
			if((char)itr.next()=='(') {
				m++;
			}
			totalCount++;
		}
		
		return (totalCount/2+m%2);
		
	}

}
