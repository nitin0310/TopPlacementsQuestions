package question36;
import java.util.*;

public class UsingMinHeap {
	//https://www.geeksforgeeks.org/nearly-sorted-algorithm/

	public static void main(String[] args) {
		DoublyLinkedList list=new DoublyLinkedList();
		list.addNode(2);
		list.addNode(6);
		list.addNode(3);
		list.addNode(12);
		list.addNode(56);
		list.addNode(8);
		list.print();
		list.sortKUsingMinHeap(2, list);
		
	}
}

class Node{
	int data;
	Node next;
	Node prev;
	Node(int data){
		this.data=data;
	}
}

class DoublyLinkedList{
	Node head;
	int length=0;
	
	void addNode(int data) {
		Node newnode = new Node(data);
		if(head==null) {
			head=newnode;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newnode;
			newnode.prev=temp;
		}
		length++;
	}
	
	void print() {
		if(head==null) {
			System.out.println("Nothing to print");
		}else {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	
	void SortLinkedList(int k,DoublyLinkedList list) {
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		Node temp=list.head;
		
		//O(n logn) --bcz everytime we are removing then heap sort run for n-1
		//i.e n and run at ( n logn ) sorting
		//but we want for logk i.e heap sort must run for k elements only
		
		while(temp!=null) {
			minHeap.add(temp.data);
			temp=temp.next;
		}
		
		list.head=null;
		Iterator itr=minHeap.iterator();
		while(itr.hasNext()) {
			list.addNode((int)minHeap.poll());
		}
	}
	
	//O(n logk)
	void sortKUsingMinHeap(int k,DoublyLinkedList list) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		DoublyLinkedList result=new DoublyLinkedList();
		
		Node temp=list.head;
		//heap sort call for k times only bcz we will only deal k elements in for loop
		for(int i=1;i<=k;i++) {
			minHeap.add(temp.data);
			temp=temp.next;
		}
		
		for(int i=k+1;i<=list.length;i++) {
			if(i!=list.length) {
				result.addNode(minHeap.remove());
			}
			minHeap.add(temp.data);
			temp=temp.next;
		}
		
		//left with last k elements
		while(!minHeap.isEmpty()) {
			result.addNode(minHeap.remove());
		}
		
		result.print();
	}
	
}
