package question16;

import java.io.*;
import java.util.*;

public class UsingQueue {
	//O(n) time										O(k) space
	//i did it
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
		
		System.out.println(findSum(array,n,k));
	}
	
	static int findSum(int array[],int n,int k) {
		
		int sum=0,i=0,j=0;
		Deque<Integer> gr = new LinkedList<Integer>();//this will hold as greater as possible at front and then in decreasing order
		Deque<Integer> sm = new LinkedList<Integer>();//this will hold as smallest as possible at front and then in increasing order
		
		while(i<=n-k) {//running only till,window can form -----O(n)
			
			//putting upcoming no. at its right pos. so that gr have same decreasing order
			while(!gr.isEmpty() && gr.peekLast()<=array[j]) {
				gr.removeLast();
			}
			//add to krna hi hai,but remove isliye kr rhe hai ki jb window slide ho to front side k no. sbse greater hi ho current window me
			gr.addLast(array[j]);
			//putting upcoming no. at its right pos. so that gr have same decreasing order
			while(!sm.isEmpty() && sm.peekLast()>array[j]) {
				sm.removeLast();
			}
			sm.addLast(array[j]);
			
			//jb window form ho jayegi, then slide hone lgegi tb
			if(j-i+1==k) {
				int max=gr.peekFirst();
				int min=sm.peekFirst();
				sum+=(min+max);
				
				//agar front hi greater hi then ab window slide kr ri hai,matlab ab no. nhi rhega current window me isliye remove
				if(array[i]==gr.peekFirst()) {
					gr.removeFirst();
				}
				if(array[i]==sm.peekFirst()) {
					sm.removeFirst();
				}
				i++;
			}
			j++;
		}
		return sum;
	}
	
}
