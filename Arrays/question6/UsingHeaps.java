package question6;
import java.io.*;
import java.util.*;

public class UsingHeaps {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int k=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pr =new PriorityQueue<Integer>();
		
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(br.readLine());
			pr.add(value);
		}												//O(n)
		
		
//		int kthElement=0;
//		for(int j=0;j<k;j++) {
//			kthElement=pr.remove();
//		}
//		System.out.print("kth smallest element : "+kthElement);
		
		int array[]=new int[n];
		int i=0;
		while(!pr.isEmpty()) {
			array[i++]=pr.poll();
		}
		
		System.out.print("Kth smallest from beg : "+array[k-1]);
		System.out.print("\nKth smallest from end : "+array[n-k]);
	}

}
