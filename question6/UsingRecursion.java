package question6;
import java.util.*;

public class UsingRecursion {
	//O(n) time											O(1) space
	static Queue<Integer> queue=new LinkedList<Integer>();
	
	public static void main(String args[]) {
		queue.add(4);
		queue.add(3);
		queue.add(1);
		queue.add(10);
		queue.add(2);
		queue.add(6);
		
		reverseQueue();
	}
	
	static void reverseQueue() {
		if(queue.isEmpty()) {
			return;
		}
		
		int data = queue.remove();
		reverseQueue();
		System.out.print(data+" ");
	}
}