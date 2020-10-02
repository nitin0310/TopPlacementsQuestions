package question27;


public class UsingLength {
	//O(n) --time
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(10);
		list.addNode(40);
		list.addNode(60);
		list.addNode(70);
		list.addNode(20);
		
		list.print();
		System.out.println("Middle element : "+list.findMiddleElement());
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
	
	int findMiddleElement() {
		int length=0;
		
		if(head==null) {
			return Integer.MIN_VALUE;
		}
		
		Node temp=head;
		while(temp!=null) {
			temp=temp.next;
			length++;
		}
		temp=head;
		if(length%2==0) {
			for(int i=1;i<length/2;i++) {
				temp=temp.next;
			}
		}else {
			for(int i=1;i<=length/2;i++) {
				temp=temp.next;
			}
		}
		
		return temp.data;
	}
}
