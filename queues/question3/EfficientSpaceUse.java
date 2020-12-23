package question3;

import java.io.*;

public class EfficientSpaceUse {
	//O(1) time for all methods							O(n) space
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n : ");
		int n=Integer.parseInt(br.readLine());
		System.out.println("Enter k : ");
		int k=Integer.parseInt(br.readLine());
		
		KQueue ks = new KQueue(n, k) ;
		  
        ks.add(15, 2); 
        ks.add(45, 2); 
  
        // Let us put some items in queue number 1 
        ks.add(17, 1); 
        ks.add(49, 1); 
        ks.add(39, 1); 
  
        // Let us put some items in queue number 0 
        ks.add(11, 0); 
        ks.add(9, 0); 
        ks.add(7, 0); 
  
        System.out.println("Popped element from stack 2 is " + ks.remove(2)); 
        System.out.println("Popped element from stack 1 is " + ks.remove(1)); 
        System.out.println("Popped element from stack 0 is " + ks.remove(0));
	}
}

class KQueue{
	
	int arr[],front[],rear[],next[];
	int free;
	
	KQueue(int n,int k){
		arr=new int[n];
		next=new int[n];
		front=new int[k];
		rear=new int[k];
		
		this.free=0;
		
		for(int i=0;i<k;i++) {
			front[i]=rear[i]=-1;
		}
		
		for(int i=0;i<n-1;i++) {
			next[i]=i+1;
		}
		next[n-1]=-1;
	}
	
	void add(int data,int qNo) {
		if(isFull()) {
			System.out.println("Can't insert! Queue is full.");
			return;
		}else {
			int nextFree = next[free];//free ko update krne k liye
			next[free]=-1;
			if(front[qNo]==-1) {
				front[qNo]=free;
				rear[qNo]=free;
			}else {
				int lastIndex = rear[qNo];
				next[lastIndex]=free;
				rear[qNo]=free;
			}
			arr[free]=data;
			free=nextFree;
		}
	}
	
	int remove(int qNo) {
		if(isEmpty(qNo)) {
			return -1;
		}else {
			int data=arr[front[qNo]];//getting top element
			if(front[qNo]==rear[qNo]) {
				free=front[qNo];
				front[qNo]=rear[qNo]=-1;
			}else {
				free=front[qNo];
				front[qNo]=next[front[qNo]];
			}
			return data;
		}
	}
	
	boolean isEmpty(int qNo) {
		return front[qNo]==-1;
	}
	
	boolean isFull() {
		return free==-1;
	}
}
