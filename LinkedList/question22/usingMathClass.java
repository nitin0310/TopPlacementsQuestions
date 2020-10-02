package question22;

import java.math.*;

public class usingMathClass {
	//O(N+M) or O(M+N) --time		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		list1.addNode(4);
		list1.addNode(5);
		list1.print();
		
		list2.addNode(3);
		list2.addNode(4);
		list2.addNode(5);
		list2.print();
		
		System.out.println(SinglyLinkedList.addBothListToNumber(list1, list2));
		
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
	
	static int addBothListToNumber(SinglyLinkedList list1,SinglyLinkedList list2) {
		int number1 = convertToNumber(list1);
		int number2 = convertToNumber(list2);
		
		return number1+number2;
	}
	
	static int convertToNumber(SinglyLinkedList list) {
		if(list.length==0) {
			return 0;
		}else {
			int number=0;
			Node temp=list.head;
			for(int i=list.length-1;i>=0;i--) {
				int value=temp.data*(int)Math.pow(10, i);
				temp=temp.next;
				number=number+value;
			}
			return number;
		}
	}
	
}