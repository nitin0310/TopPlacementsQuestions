package question19;

import java.util.*;

public class usingHashSet {
	//O(n)  --time		O(n)  --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(1);
		list.addNode(5);
		list.addNode(2);
		list.addNode(5);
		list.addNode(6);
		list.addNode(1);
		list.addNode(2);
		list.print();
		list.removeDuplicates(list);
		list.print();
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
	//linked hash set maintain insertion order as well
	LinkedHashSet<Integer> hashSet = new LinkedHashSet<Integer>();
	
	
	void addNode(int data) {
		Node newnode = new Node(data);
		hashSet.add(data);
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
	
	void removeDuplicates(SinglyLinkedList list) {
		if(head==null) {
			System.out.println("Nothing to remove");
		}else {
			head=null;
			Iterator itr=hashSet.iterator();
			while(itr.hasNext()) {
				list.addNode((int)itr.next());
			}
		}
	}
	
}