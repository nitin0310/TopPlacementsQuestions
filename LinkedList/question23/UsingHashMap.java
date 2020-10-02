package question23;

import java.util.*;

public class UsingHashMap {
	//(n+m) --time 		O(n+m) --space
	//but not so good because we lost list1
	public static void main(String args[]) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		list1.addNode(4);
		list1.addNode(6);
		list1.addNode(7);
		list1.addNode(9);
		list1.addNode(10);
		list1.print();
		
		list2.addNode(6);
		list2.addNode(8);
		list2.addNode(9);
		list2.addNode(11);
		list2.print();
		
		SinglyLinkedList.printIntersectingElements(list1, list2);
		list1.print();
	}
}

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
	}
}

class SinglyLinkedList{
	Node head;
	
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
		}
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
	
	static void printIntersectingElements(SinglyLinkedList list1,SinglyLinkedList list2) {
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		Node temp=list1.head;
		while(temp!=null) {
			hashMap.put(temp.data, 1);
			temp=temp.next;
		}
		list1.head=null;
		
		temp=list2.head;
		while(temp!=null) {
			if(hashMap.containsKey(temp.data)) {
				list1.addNode(temp.data);
			}
			temp=temp.next;
		}
	}
}
