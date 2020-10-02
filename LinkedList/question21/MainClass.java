package question21;

public class MainClass {
	//O(n) --time		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
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
			while(temp.next!=null) {
				System.out.print(temp.data);
				temp=temp.next;
			}
			System.out.print(temp.data+1);
			System.out.println();
		}
	}
	
	
}