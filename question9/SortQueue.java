package question9;
import java.util.*;

/*
Sorting a Queue without extra space
O(n^2) time--recursion O(n),within it n times loop				O(1) space
*/

public class SortQueue {
	public static void main(String args[]) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(13);
		queue.add(9);
		queue.add(14);
		queue.add(17);
		queue.add(7);
		queue.add(2);
		
		sortQ(queue);
		printQueue(queue);
	}
	
	static void sortQ(Queue<Integer> queue) {
		if(queue.isEmpty()) {
			return;
		}
		
		//hold values till last and then insert it to its correct place
		int data=queue.remove();
		sortQ(queue);
		sortedInsert(data,queue);
	}
	
	static void sortedInsert(int data,Queue<Integer> queue) {
		if(queue.size()==0) {//when no element present there
			queue.add(data);
		}else {
			int size=queue.size();
			int checkedNo=0;//hold no's already checked for greater or smaller than data
			boolean dataAdded=false;
			
			while(checkedNo<size) {//we can't make condition for empty() bcz we are adding or removing inside it, so it may run for infinite
				int front=queue.peek();
				if(front<data) {//if data is greater, then we only need remove front and again add it to  back.
					queue.add(queue.remove());
				}else {//else, we update it to true that yeah we added the data
					dataAdded=true;
					queue.add(data);
					break;//bcz once we add it than we don't need to check it with front anymore,it get it's correct place already
				}
				checkedNo++;//update when a no. is done and we haven't inserted data yet
			}
			
			if(!dataAdded) {//may we have checked the full queue, and haven't added data then for sure all elements are smaller to it and insert it to the back
				queue.add(data);
			}
			//let suppose the data is added in between then for sure some elements are left at front those need to insert at back, so run a loop for them
			for(int i=1;i<=size-checkedNo;i++) {
				queue.add(queue.remove());
			}
		}
	}
	
	static void printQueue(Queue<Integer> queue) {
		while(!queue.isEmpty()) {
			System.out.print(queue.remove()+" ");
		}
	}
}
