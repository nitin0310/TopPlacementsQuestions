package question16;

public class MainClass {

	public static void main(String[] args) {
		Dequeue stack=new Dequeue();
		stack.addLast(3);
		stack.addLast(6);
		stack.addLast(9);
		stack.print();
		
		stack.removeLast();
		stack.removeLast();
		stack.print();
		
		
		Dequeue queue=new Dequeue();
		queue.addLast(7);
		queue.addLast(8);
		queue.addLast(9);
		queue.print();
		
		queue.removeFirst();
		queue.removeFirst();
		queue.print();
	}

}

class Node{
	Node prev;
	Node next;
	int data;
	
	Node(int data){
		this.data=data;
	}
}

class Dequeue{
	Node head;
	Node tail;
	
	void addFirst() {
		//no use
	}
	
	void addLast(int data) {
		Node newnode=new Node(data);
		if(head==null && tail==null) {
			head=tail=newnode;
		}else {
			newnode.prev=tail;
			tail.next=newnode;
			tail=newnode;
		}
	}
	
	void removeFirst() {
		if(head==null) {
			System.out.println("null");
		}else {
			Node temp=head.next;
			temp.prev=null;
			head=temp;
		}
	}
	
	void removeLast() {
		if(head==tail) {
			head=null;
			tail=null;
		}else {
			Node temp=tail.prev;
			temp.next=null;
			tail=temp;
		}
	}
	
	boolean isEmpty() {
		if(head==null && tail==null) {
			return true;
		}
		return false;
	}
	
	void print() {
		if(isEmpty()) {
			System.out.println("Nothing to print");
		}else {
			Node temp=head;
			while(temp!=tail) {
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.print(temp.data+" ");
			System.out.println();
		}
	}
	
}
