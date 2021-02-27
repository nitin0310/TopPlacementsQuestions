package fixedSizeWindow;
import java.util.*;

//Maximum of all sub-arrays of size k
//O(n) time, bcz worst case me bhi hme sbhi elements me se check nhi krna
//O(n) space

public class Question4 {
	public static void main(String args[]) {
		int[] array= {1,3,-1,-3,5,3,6,7};
		int n=8;
		int k=3;
		
		maxOfAllSubArrays(array,n,k);
	}
	
	static void maxOfAllSubArrays(int[] array,int n,int k) {
		Deque<Integer> deque=new LinkedList<Integer>();
		int start=0;
		
		for(int end=0;end<n;end++) {
			addCorrect(deque,array[end]);
			
			if(end-start+1==k) {
				System.out.print(deque.peek()+" ");
				if(array[start]==deque.peek()) {
					deque.removeFirst();
				}
				start++;
			}
		}
	}
	
	static void addCorrect(Deque<Integer> deque,int item) {
		if(deque.isEmpty()) {
			deque.add(item);
		}else {
			
			if(item>=deque.peek()) {								//agar upcoming item already present se bda hai, to jb tk wo nikal na jaaye window se or us se bda na aa jaye tb tk whi bda rhega
				while(deque.peek()>item) {							//so us se chote sbhi ko nikal do
					deque.removeFirst();	
				}
				deque.addFirst(item);
			}else {													//agar ye front se chota hai, to matlab current window ka max hai abhi deque me, to ise piche daal do kya pta aage kaam aa jaye
				deque.addLast(item);
			}
			
		}
	}
}
