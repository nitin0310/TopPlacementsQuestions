package question16;

public class MainClass {
	static Node head;
	public static void main(String args[]) {
		head=new Node(10);
		
		Node node1=new Node(20);
		head.next=node1;
		node1.prev=head;
		
		Node node2=new Node(30);
		node1.next=node2;
		node2.prev=node1;
		
		printList(head);
		head=reverseDList(head);
		printList(head);
	}
	
	static Node reverseDList(Node temp) {
		
		if(temp==null)
			return temp;
		
		if(temp.next==null)
			return temp;
		
		Node node = reverseDList(temp.next);
		temp.next.next=temp;//linking reversely
		temp.next=null;
		head=node;				//most important to do
		return node;
	}
	
	static void printList(Node head) {
		Node node=head;
		while(node!=null) {
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	
}

class Node{
	Node next;
	Node prev;
	int data;
	
	Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}
