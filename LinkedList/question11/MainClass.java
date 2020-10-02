package question11;


public class MainClass {
	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.print();
		list.reverseList();
		list.print();
		list.getNthNodeFromBack(2);
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
	
	
	void getNthNodeFromBack(int value) {
		if(head==null) {
			System.out.println("List is empty");
		}else {
			if(length<value) {
				System.out.println("Enter valid value!");
			}else {
				Node temp=head;
				for(int i=1;i<value;i++) {
					temp=temp.next;
				}
				System.out.println("Value fetched : "+temp.data);
			}
		}
	}
}