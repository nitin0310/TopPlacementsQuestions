package question_20;
import java.io.*;
import java.util.*;

public class UsingMaxHeap {

	//restricted time complexity : O(n logn)	or can be done using mergesort
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String string[]=br.readLine().trim().split(" ");
																//============================
		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(10,Collections.reverseOrder()	/** O(n)*/);
																//============================
		
		for(int i=0;i<string.length;i++) {					//O(n)
			maxHeap.add(Integer.parseInt(string[i]));		//log(n)
		}
		
		System.out.println("largest three elements : ");
		for(int i=0;i<3;i++) {
			System.out.print(maxHeap.poll()+" ");
		}		//O(3 logn)
	
	}

}
