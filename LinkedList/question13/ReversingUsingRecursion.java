package question13;


public class ReversingUsingRecursion {
	//O(n) --time 		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(10);
		list.addNode(15);
		list.addNode(20);
		list.addNode(25);
		list.print();
		list.reverseUsingRecursion(list.head);
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
	
	Node reverseUsingRecursion(Node temp) {
		//recursively nodes ka link update hota rhega and last node ko aage tk
		//leta chalna as head
		if(temp==null)
			return temp;
		
		if(temp.next==null)
			return temp;
		
		
		Node node = reverseUsingRecursion(temp.next);
		temp.next.next=temp;
		temp.next=null;
		head=node;				//most important to do
		return node;
	}
}