package question30;

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
		list.deleteNode(30);
		list.printCircularLL();
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
	
	
	void deleteNode(int data) {
		int flag=0;
		if(head==null) {
			flag=0;
		}
		
		if(head.data==data) {
			head=head.next;
			flag=1;
		}
		
		Node temp=head.next;
		while(temp!=head) {
			if(head.next.data==data) {
				head.next=head.next.next;
				flag=1;
				return;
			}
			if(temp.next.data==data) {
				temp.next=temp.next.next;
				flag=1;
				return;
			}
			temp=temp.next;
		}
		
		if(flag==0) {
			System.out.println("Nothing to delete");
		}
	}
	
}
