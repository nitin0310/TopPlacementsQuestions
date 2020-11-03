package question1;
import java.util.*;

public class UsingStacks {
	//O(n) --time 		O(1) --space
	public static void main(String args[]) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stacks = new Stack<Integer>();
		
		int k=3;
		
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		
		Iterator itr=queue.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		System.out.println("\nAfter reversing");
		
		//adding k elements to stacks,at the same k elements removed from queue also
		for(int i=0;i<k;i++) {
			stacks.add(queue.poll());
		}
		
		//adding k elements of stack to back of queue(inserted in reversing order)
		for(int i=0;i<k;i++) {
			queue.add(stacks.pop());
		}
		
		//adding to back those should be at back
		for(int i=0;i<queue.size()-k;i++) {
			queue.add(queue.poll());
		}
		
		Iterator itr2=queue.iterator();
		while(itr2.hasNext()) {
			System.out.print(itr2.next()+" ");
		}
		
		
	}
}
