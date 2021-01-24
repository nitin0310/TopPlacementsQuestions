package question15;

public class MainClass {
	public static void main(String args[]) {
		Node head=new Node(9);
		head.next=new Node(8);
		head.next.next=new Node(3);
		head.next.next.next=new Node(5);
		head.next.next.next.next=new Node(2);
		head.next.next.next.next.next=new Node(1);
		
		printLinkedList(head);
		removeKthNode(head,1,4);
		printLinkedList(head);
	}
	
	static Node removeKthNode(Node node,int count,int k) {
		
		if(node==null) {
			return null;
		}//if we encounter no element or single element
		
		if(count==k) {
			return node.next;//if count==k, then only return next node reference, no need to make more calls further
		}
		
		node.next=removeKthNode(node.next,count+1,k);//make calls to reach k,and return their own reference to previous
		return node;
	}
	
	static void printLinkedList(Node head) {
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
	int data;
	
	Node(int data){
		this.next=null;
		this.data=data;
	}
}
