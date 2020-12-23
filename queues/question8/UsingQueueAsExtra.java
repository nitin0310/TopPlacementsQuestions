package question8;
import java.util.*;

/*
Interleave the first half of the queue with second half.
*/

public class UsingQueueAsExtra {
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
		int size = queue.size();
		
		Queue<Integer> firstHalf=new LinkedList<Integer>();
		Queue<Integer> secondHalf=new LinkedList<Integer>();
		
		for(int i=1;i<=size/2;i++) {
			firstHalf.add(queue.remove());
		}
		
		for(int i=1;i<=size/2;i++) {
			secondHalf.add(queue.remove());
		}
		
		for(int i=1;i<=size/2;i++) {
			int first=firstHalf.remove();
			int second=secondHalf.remove();
			
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
