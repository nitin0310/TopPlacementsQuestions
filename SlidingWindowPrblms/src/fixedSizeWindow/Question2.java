package fixedSizeWindow;
import java.util.*;

//First negative in every window size of k
//O(n) time
//O(k) space

public class Question2 {

	public static void main(String[] args) {
		int[] array= {-8,2,3,-6,10};
		int n=5;
		int k=2;
		
		firstNeg(array,n,k);
	}
	
	
	static void firstNeg(int[] array,int n,int k) {
		int start=0;
		Queue<Integer> queue=new LinkedList<Integer>();
		
		for(int end=0;end<n;end++) {
			if(array[end]<0) {										//agar -ve hai to queue me add kr do, aage kaam aayega
				queue.add(array[end]);
			}
			
			if(end-start+1==k) {									//jb window ban jaaye size ki, to queue me front element hi hoga jo pehle -ve exist krta hoga is window me,wrna remove ho chuka hoa abhi tk,else queue empty hai to iska matlab,iss window me koi -ve hai hi nhi
				
				if(queue.isEmpty())	{System.out.print(0+" ");}
				
				else if(queue.peek()==array[start]) {System.out.print(queue.remove()+" ");}			//agar queue ka front hi window se remove hone wala hai to matlab ab iska koi kaam nhi, ab wo window ka part nhi to first -ve kaise ho skta hai, so remove from queue
				
				else {System.out.print(queue.peek()+" ");}
				
				start++;
			}
		}
		
		
	}

}
