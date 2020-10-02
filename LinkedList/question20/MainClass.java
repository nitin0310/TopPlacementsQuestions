package question20;

public class MainClass {
	//O(n) --time		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.print();
		list.insertLastToFirst();
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
	
	void insertLastToFirst() {
		if(head==null || head.next==null) {
			System.out.println("Can't shift");
		}else {
			Node temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			temp.next.next=head;
			head=temp.next;
			temp.next=null;
		}
	}
	
}