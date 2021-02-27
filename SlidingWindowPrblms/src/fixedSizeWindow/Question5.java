package fixedSizeWindow;

import java.util.Deque;
import java.util.LinkedList;

//Maximum of( minimum for all (window size))
//O(n^2) time
//O(n) space

public class Question5 {
	public static void main(String args[]) {
		int[] array= {10,20,30,50,10,70,30};
		int n=7;
		
		maxOfMin(array,n);
	}
	
	static void maxOfMin(int[] array,int n) {
		
		for(int k=1;k<=n;k++) {							//represents window size
			int min=Integer.MAX_VALUE;
			
			System.out.print(minOfAllSubArraysOfSizeK(array,n,k,min)+" ");
		}
	}
	
	
	static int minOfAllSubArraysOfSizeK(int[] array,int n,int k,int minValue) {
		Deque<Integer> deque=new LinkedList<Integer>();
		int start=0;
		int maximum=Integer.MIN_VALUE;
		
		for(int end=0;end<n;end++) {
			addCorrect(deque,array[end]);
			
			if(end-start+1==k) {
				minValue=deque.peek();
				if(minValue>maximum) {
					maximum=minValue;
				}
				if(array[start]==deque.peek()) {
					deque.removeFirst();
				}
				start++;
			}
		}
		
		return maximum;
	}
	
	static void addCorrect(Deque<Integer> deque,int item) {
		if(deque.isEmpty()) {
			deque.add(item);
		}else {
			
			if(item<=deque.peek()) {	//make sure to consider = as well			//agar upcoming item already present se bda hai, to jb tk wo nikal na jaaye window se or us se bda na aa jaye tb tk whi bda rhega
				while(deque.peek()<item) {							//so us se chote sbhi ko nikal do
					deque.removeFirst();	
				}
				deque.addFirst(item);
			}else {													//agar ye front se chota hai, to matlab current window ka max hai abhi deque me, to ise piche daal do kya pta aage kaam aa jaye
				deque.addLast(item);
			}
			
		}
	}
}
