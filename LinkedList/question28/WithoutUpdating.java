package question28;

public class WithoutUpdating {
	
	//O(n) --time 		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList1 list=new SinglyLinkedList1();
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


class Node1{
	int data;
	Node1 next;
	Node1(int data){
		this.data=data;
	}
}

class SinglyLinkedList1{
	Node1 head;
	
	void addNode(int data) {
		Node1 newnode = new Node1(data);
		if(head==null) {
			head=newnode;
		}else {
			Node1 temp=head;
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
			Node1 temp=head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	
	void createCircularLL() {
		Node1 temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
	}
	
	boolean checkCircularLL() {
		if(head==null)
			return false;
		
		if(head.next==null)
			return false;
		
		Node1 temp=head.next;
		while(temp!=null) {
			if(temp==head)
				return true;
			temp=temp.next;
		}
		return false;
	}
	
}
