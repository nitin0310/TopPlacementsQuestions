package question3;

import java.util.PriorityQueue;
import java.util.Stack;

public class UsingRecursion1 {
	//O(n) --time 			O(n) --space
	public static void main(String args[]) {
		Stack<Integer> stack=new Stack<Integer>();
		PriorityQueue<Integer> pQueue=new PriorityQueue<Integer>();
		
		
		stack.push(1);
		stack.push(3);
		stack.push(2);
		
		sortTheStack(stack,pQueue);
		
		System.out.println("After sorting : ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	static void sortTheStack(Stack stack,PriorityQueue pQueue) {
		if(stack.isEmpty()) {
			return;
		}
		
		pQueue.add(stack.pop());
		sortTheStack(stack,pQueue);
		stack.push(pQueue.remove());
	}
}
