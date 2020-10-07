package question37;

public class UsingLoops {
	//O(n) --time(to reach last node or length as well) 		O(1) --space
	public static void main(String args[]) {
		DoublyLinkedList list=new DoublyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.print();
		list.rotateByN(2);
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
			newnode.prev=temp;
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
	
	void rotateByN(int n) {
		Node temp=head;
		Node prevHead=head;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		for(int i=1;i<=n;i++) {
			temp=temp.prev;
		}
		temp.prev.next=null;
		head=temp;
		head.prev=null;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		
		temp.next=prevHead;
		prevHead.prev=temp;
	}
	
}
