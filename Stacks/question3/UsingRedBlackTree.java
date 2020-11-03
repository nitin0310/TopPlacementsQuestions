package question3;

import java.util.*;

public class UsingRedBlackTree {
	
	//O(n) --time 		O(n) --space
	//but question wants recursive approach
	public static void main(String args[]) {
		Stack<Integer> stack=new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack=sortTheStack(stack);
		
		System.out.println("After sorting : ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	
	static Stack sortTheStack(Stack stack) {
		PriorityQueue<Integer> pQueue=new PriorityQueue<Integer>();
		
		while(!stack.isEmpty()) {
			pQueue.add((Integer)stack.pop());
		}
		
		while(!pQueue.isEmpty()) {
			stack.push(pQueue.poll());
			System.out.println(stack.peek());
		}
		
		return stack;
	}
}
