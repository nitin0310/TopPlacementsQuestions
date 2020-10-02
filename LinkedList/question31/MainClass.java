package question31;

public class MainClass {
	//O(n) --time 		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.createCircularLL();
		list.printCircularLL();
		System.out.println(list.countNodes());
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
	
	void printCircularLL() {
		if(head==null) {
			System.out.println("Nothing to print");
		}else {
			Node temp=head.next;
			System.out.print(head.data+" ");
			while(temp!=head) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	
	void createCircularLL() {
		if(head==null) {
			System.out.println("Nothing");
		}
		
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
	}
	
	int countNodes() {
		if(head==null) {
			return 0;
		}else if(head.next==null) {
			return 1;
		}else {
			int length=1;
			Node temp=head.next;
			while(temp!=head) {
				length++;
				temp=temp.next;
			}
			return length;
		}
	}
	
}
