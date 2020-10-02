package question15;
import java.util.*;


public class UsingHashing {
	//O(n) --time  		O(n) --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(20);
		list.addNode(4);
		list.addNode(15);
		list.addNode(10);
		list.print();
		list.head.next.next.next.next=list.head;
		System.out.println(list.checkLoop());
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
	int length=0;
	HashSet<Integer> set=new HashSet<Integer>();
	
	
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
	
	boolean checkLoop() {
		
		Node temp=head;
		while(temp!=null) {
			if(set.contains(temp.data)) {
				return true;
			}else {
				set.add(temp.data);
			}
			temp=temp.next;
		}
		return false;
	}
}