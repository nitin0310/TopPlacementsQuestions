package question2;
import java.util.*;

public class MainClass {
	public static void main(String args[]) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		printStack(stack);
		reverseStack(stack);
		printStack(stack);
	}
	
	static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty())
			return;
		
		int topElement=stack.pop();
		reverseStack(stack);
		insert(stack,topElement);
	}
	
	static void insert(Stack<Integer> stack,int element) {
		if(stack.size()==0) {
			stack.push(element);
			return;
		}
		
		int topElement=stack.pop();
		insert(stack,element);
		stack.push(topElement);
	}
	
	static void printStack(Stack<Integer> stack) {
		Iterator<Integer> itr=stack.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}
}
