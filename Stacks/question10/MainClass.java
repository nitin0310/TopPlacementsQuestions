package question10;
import java.io.*;
import java.util.*;

public class MainClass {
	//O(n^2-n^3) --time			O(n) --space
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String exp=br.readLine();
		decodeString(exp);
	}
	
	static void decodeString(String exp) {
		Stack<Integer> intStack=new Stack<Integer>();
		Stack<Character> charStack=new Stack<Character>();
		
		for(int i=0;i<exp.length();i++) {
			
			char ch=exp.charAt(i);
			
			//checking and inserting digit(0-9) if any
			if(Character.isDigit(ch)) {
				intStack.push(Character.getNumericValue(ch));
			}else {
				//when we get ) we need to remove all char till we get )
				if(ch==')') {
					String tempString="";
					while(charStack.peek()!='(') {
						//adding all char to string
						tempString=tempString+charStack.pop();
					}
					//at last removing )
					if(charStack.peek()=='(') {
						charStack.pop();
					}
					int x=intStack.pop();
					decodeSmallString(tempString,charStack,x);
				}else {
					charStack.push(ch);
				}
			}
			
		}
		
		Iterator itr=charStack.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next());
		}
	}
	
	static void decodeSmallString(String temp,Stack charStack,int x) {
		
		for(int i=0;i<x;i++) {
			for(int j=temp.length()-1;j>=0;j--) {
				//adding all characters in a series x times to charStack
				charStack.push(temp.charAt(j));
			}
		}
	}
	
}
