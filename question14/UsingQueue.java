package question14;
import java.util.*;
import java.io.*;

public class UsingQueue {
	//O(n) time							O(n) space
	//best aditya verma series
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n : ");
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		System.out.println("Enter array elements : ");
		String str[]=br.readLine().trim().split(" ");
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(str[i]);
		}
		System.out.println("Enter k : ");
		int k=Integer.parseInt(br.readLine());
		findFirstNeg(array,n,k);
	}
	
	static void findFirstNeg(int[] array,int n,int k) {
		Queue<Integer> queue=new LinkedList<Integer>();
		
		int i=0,j=0;
		
		while(i<=n-k) {
			//if we encounter -ve we add it to the queue
			if(array[j]<0) {
				queue.add(array[j]);
			}
			//condition true when window forms --(j-i+1)==k size of window
			if((j-i+1)==k) {
				if(queue.isEmpty()) {			//if nothing in the list,it means no -ve encounter in this window from start to end
					System.out.print(0+" ");
				}else if(queue.peek()==array[i]){
					//if front is the ith element,that means this is the first element of current window and in next upcoming window it will present that's why we are removing
					System.out.print(queue.remove()+" ");
				}else {
					//it means the -ve element possible in the current window is front at queue
					System.out.print(queue.peek()+" ");
				}
				//it is incremented when we need to slide window
				i++;
			}
			//it is incremented every time bcz we need to complete window
			j++;
		}
	}
}