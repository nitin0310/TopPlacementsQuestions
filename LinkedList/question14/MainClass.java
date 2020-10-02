package question14;

public class MainClass {
	//O(n) --time  		O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.print();
		list.reverseList(list.head, 3);
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
	
	Node reverseList(Node node,int k) {
		int count=1;
		Node prev=null,current=node,next=null;
		
		while(count<=k && current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
			count++;
		}
		if(next!=null) {
			node.next = reverseList(next,k);
		}
		head=prev;			//most important to update in recursion
		return prev;
	}
	
	
}