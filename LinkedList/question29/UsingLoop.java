package question29;

public class UsingLoop {
	public static void main(String args[]) {
		//O(n) --time 		O(1) --space
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.print();
		list.divideInTwoHalves();
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
	
	static Node createCircularLL(Node head) {
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
		return head;
	}
	
	void divideInTwoHalves() {
		if(head==null) {
			System.out.println("Nothing divisible");
		}
		Node temp=head;
		
		if(length%2==0) {
			for(int i=1;i<length/2;i++) {
				temp=temp.next;
			}
			
		}else {
			for(int i=1;i<=length/2;i++) {
				temp=temp.next;
			}
		}
		
		Node nextToTemp=temp.next;
		temp.next=null;
		Node list1Head=createCircularLL(head);
		Node list2Head=createCircularLL(nextToTemp);
		
		printCircularLL(list1Head);
		printCircularLL(list2Head);
	}
	
	void printCircularLL(Node head) {
		if(head==null)
			System.out.println("Nothing to print");
		
		if(head.next==head)
			System.out.println(head.data);
		
		
		Node temp=head.next;
		System.out.print(head.data+" ");
		while(temp!=head) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	
}
