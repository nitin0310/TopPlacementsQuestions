package question10;

public class ReverseSinglyLL {
	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.print();
		list.reverseList();
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
	
	Node reverseList() {
		if(head==null) {
			return head;
		}else {
			Node prev=null,current=head,next=current.next;
			while(next!=null) {
				current.next=prev;
				prev=current;
				current=next;
				next=next.next;
			}
			current.next=prev;
			head=current;
			return head;
		}
	}
	
}