package question28;

public class UpdatingNodeValue {
	
	//O(n) --time 		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.print();
		list.createCircularLL();
		System.out.println("Check circularLL : "+list.checkCircularLL());
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
	
	void createCircularLL() {
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
	}
	
	boolean checkCircularLL() {
		if(head==null)
			return false;
		
		Node temp=head;
		while(temp!=null) {
			if(temp.data==Integer.MIN_VALUE) {
				return true;
			}
			temp.data=Integer.MIN_VALUE;
			temp=temp.next;
		}
		return false;
	}
	
}
