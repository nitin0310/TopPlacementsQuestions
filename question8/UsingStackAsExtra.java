package question8;
import java.util.*;

public class UsingStackAsExtra {
	//O(n) time											O(n) space
	public static void main(String args[]) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);
		queue.add(15);
		queue.add(16);
		queue.add(17);
		queue.add(18);
		queue.add(19);
		queue.add(20);
		
		interLeave(queue);
		printQueue(queue);
	}
	
	static void interLeave(Queue<Integer> queue) {
		Stack<Integer> stack=new Stack<Integer>();
		
		int size=queue.size();
		
		//we did this step bcz we want first half elements in same series as they are given
		//in original queue, in the stack.
		for(int i=1;i<=size/2;i++) {
			stack.push(queue.remove());
		}
		
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		
		for(int i=1;i<=size/2;i++) {
			queue.add(queue.remove());
		}
		
		//so finally we have these in the same series as we want.
		for(int i=1;i<=size/2;i++) {
			stack.push(queue.remove());
		}
		
		for(int i=1;i<=size/2;i++) {
			int first=stack.pop();
			int second=queue.remove();
			
			queue.add(first);
			queue.add(second);
		}
		
	}
	
	static void printQueue(Queue<Integer> queue) {
		while(!queue.isEmpty()) {
			System.out.print(queue.remove()+" ");
		}
	}
}
