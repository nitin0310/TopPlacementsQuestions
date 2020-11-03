package question30;
import java.io.*;
import java.util.*;

public class MainClass {
//evaluating arithmetic expression
//given expr->post fix expr->evaluate
	
/*
 this is working fine but only problem is, it requires (,) braces to convert to postfix
 */
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter expression:");
		String expression=br.readLine();
		
		System.out.println(evaluateExpression(expression));
		}
	
	static int evaluateExpression(String expr) {
		String exp=convertToPostfix(expr);
		Stack<Integer> stack=new Stack<Integer>();
		
		for(int i=0;i<exp.length();i++) {
			char ch=expr.charAt(i);
			
			if(isOperator(ch)) {
				int first=stack.pop();
				int second=stack.pop();
				
				int result=evaluateValue(ch,first,second);
				stack.push(result);
			}else {
				stack.push(Character.getNumericValue(ch));
			}
		}
		return stack.pop();
	}
	
	static int evaluateValue(char ch,int first,int second) {
		
		switch(ch) {
		case '^':
			return (int)first^second;
		case '/':
			return (int)first/second;
		case '*':
			return (int)first*second;
		case '+':
			return (int)first+second;
		case '-':
			return (int)first-second;
		}
		return -1;
	}
	
	static String convertToPostfix(String exp) {
		String result = new String(""); 
        
        // initializing empty stack
        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
            // If the scanned character is an 
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(',  
            // push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')',  
            // pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop(); 
                } 
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
            	//real life logic to remember
            	/*
            	 agar kisi greeb k pass ameer baith jayega to allow kr denge bcz majburi ho skti hai
            	 agar koi gareeb ameer k pass chala jaaye to ego hurt ho jayegi ameer ki to wo sb pop ho jayenge uske barabar tk k bhi
            	 agar koi ameer pehle se gareeb k pass baitha hai, or koi same status unhe dekh le to ameer wale ki insult to waha se chala jayega
            	 that's it.
            	 */
                while (!stack.isEmpty() && getPrecedence(c)<= getPrecedence(stack.peek())){
                    result += stack.pop(); 
             } 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
        return result; 
	}
	
	static boolean isOperator(char ch) {
		if(ch=='+' ||ch=='-' ||ch=='*' ||ch=='/' ||ch=='^' || ch=='(' ||ch==')') {
			return false;
		}
		return true;
	}
	
	static int getPrecedence(char ch) {
		if(ch=='^') {
			return 3;
		}else if(ch=='*' || ch=='/') {
			return 2;
		}else if(ch=='+' || ch=='-'){
			return 1;
		}else {
			return -1;
		}
	}
}
