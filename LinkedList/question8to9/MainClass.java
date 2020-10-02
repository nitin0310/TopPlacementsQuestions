package question8to9;


public class MainClass {
	public static void main(String args[]) {
		DoublyLinkedList list=new DoublyLinkedList();
		list.addNodeAtBegin(10);
		list.addNodeAtEnd(20);
		list.addNodeAtBegin(5);
		list.addNodeAtEnd(25);
		System.out.println("length of list : "+list.length());
		list.print();
		System.out.println("search 10 "+list.search(10));
		list.deleteAny(20);
		list.print();
		list.getNthNode(2, list.length());
		list.addNodeAtEnd(15);
		list.print();
		System.out.println("Count : "+list.countValue(5));
		list.findMinAndMax();
	}
}

class Node{
	int value;
	Node prev;
	Node next;
	Node(int value){
		this.value=value;
		this.next=null;
		this.prev=null;
	}
}

class DoublyLinkedList{
	Node head=null;
	Node tail=null;
	
	Node createNewNode(int data) {
		Node newnode = new Node(data);
		return newnode;
	}
	
	void addNodeAtBegin(int data) {
		Node node = createNewNode(data);
		if(head==null) {
			head=node;
			tail=node;
		}else{
			node.next=head;
			head=node;
		}
	}
	
	void addNodeAtEnd(int data) {
		Node node = createNewNode(data);
		if(head==null) {
			head=node;
			tail=node;
		}else {
			tail.next=node;
			node.prev=node;
			tail=node;
		}
	}
	
	int length() {
		if(head==null) {
			return 0;
		}else {
			int count=0;
			Node temp=head;
			while(temp!=null) {
				count++;
				temp=temp.next;
			}
			return count;
		}
	}
	
	void print() {
		if(head==null) {
			System.out.println("Nothing to print");
		}else {
			Node temp=head;
			while(temp!=null) {
				System.out.print(temp.value+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	
	boolean search(int data) {
		if(head==null) {
			return false;
		}else {
			Node temp=head;
			while(temp!=null) {
				if(temp.value==data) {
					return true;
				}
				temp=temp.next;
			}
			return false;
		}
		
	}
	
	void deleteAny(int data) {
		if(head==null) {
			System.out.println("Nothing to delete");
		}else {
			Node temp=head;
			while(temp!=null) {
				if(temp.value==data) {
					temp.prev.next=temp.next;
					temp.next.prev=temp.prev;
					break;
				}
				temp=temp.next;
			}
			if(temp==null) {
				System.out.println("Nothing deleted! Enter valid value");
			}
		}
	}
	
	void getNthNode(int value,int length) {
		if(head==null) {
			System.out.println("Nothing stored");
		}else {
			Node temp=head;
			if(value<=length) {
				for(int index=1;index<value;index++) {
					temp=temp.next;
				}
				System.out.println(temp.value);
			}else {
				System.out.println("Enter valid Nth node");
			}
			
		}
	}
	
	int countValue(int data) {
		if(head==null) {
			return 0;
		}else {
			Node temp=head;
			int count=0;
			while(temp!=null) {
				if(temp.value==data) {
					count++;
				}
				temp=temp.next;
			}
			return count;
		}
	}
	
	void findMinAndMax() {
		if(head==null) {
			System.out.println("Nothing in the list");
		}else {
			Node temp=head;
			int max=temp.value,min=temp.value;
			while(temp!=null) {
				if(temp.value>max)
					max=temp.value;
				
				if(temp.value<min)
					min=temp.value;
				
				temp=temp.next;
			}
			
			System.out.println("min : "+min);
			System.out.println("max : "+max);
		}
	}
	
	void convertToCircularLL() {
		if(head==null) {
			System.out.println("nothing to convert");
		}else {
			tail.next=head;
			head.prev=tail;
		}
	}
	
	void convertToSinglyLL() {

		if(head==null) {
			System.out.println("nothing to convert");
		}else {
			tail.next=null;
			head.prev=null;
		}
	}
	
	
}
