package question33;

public class UsingLoop {
	//O(n) --time 		O(1) --space
	public static void main(String args[]) {
		DoublyLinkedList list=new DoublyLinkedList();
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
	Node prev;
	Node(int data){
		this.data=data;
	}
}

class DoublyLinkedList{
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
			newnode.prev=temp;
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
	
	void reverseList() {
		if(head==null) {
			System.out.println("nothing to revert");
		}else if(head.next==null) {
			System.out.println("can't revert single element");
		}else {
			
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			
			Node prev;
			while(temp!=null) {
				prev=temp.prev;
				temp.prev=temp.next;
				if(temp.next==null) {
					head=temp;
				}
				temp.next=prev;
				temp=temp.next;
			}
			
		}
	}
	
	
}
