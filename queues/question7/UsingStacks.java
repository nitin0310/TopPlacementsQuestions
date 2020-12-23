package question7;
import java.util.*;

public class UsingStacks {
	//can also be done using another queue, with few modifications using for loop
	//O(n) times										O(k) space
	//only add,remove,size,front is allowed
	public static void main(String args[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(4);
		queue.add(3);
		queue.add(1);
		queue.add(10);
		queue.add(2);
		queue.add(6);
		
		reverseKQueue(3,queue);
	}
	
	static void reverseKQueue(int k,Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=1;i<=k;i++) {
			stack.push(queue.remove());
		}
		System.out.println("Queue size : "+queue.size());
		
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		System.out.println("Queue size : "+queue.size());
		for(int i=1;i<=queue.size()-k;i++) {
			queue.add(queue.remove());
		}
		System.out.println("Queue size : "+queue.size());
		//printing queue
		
		while(!queue.isEmpty()) {//can also do using for loop with queue size
			System.out.print(queue.remove()+" ");
		}
	}
	
}
