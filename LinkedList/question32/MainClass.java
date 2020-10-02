package question32;

public class MainClass {
	//O(n) --time 		O(1) --space
	public static void main(String[] args) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(10);
		list.addNode(30);
		list.addNode(50);
		list.addNode(70);
		list.print();
		list.updateFirstAndLast();
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

	void updateFirstAndLast() {
		if(head==null || head.next==null) {
			System.out.println("There's nothing in the list");
		}else {
			int first=head.data;
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			head.data=temp.data;
			temp.data=first;
		}
			
	}
	
}
