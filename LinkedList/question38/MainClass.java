package question38;

public class MainClass {
	
	//O(n) --time 		O(1) --space
	//recursion used to reach at last quickly
	
	public static void main(String[] args) {
		DoublyLinkedList list=new DoublyLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(7);
		list.print();
		list.head = list.reverseList(list.head, 3);
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
	
	
	Node reverseList(Node head,int k) {
		
		int count=1;
		Node next=null;
		Node current=head;
		Node newHeadReceived=null;
		
		//run according to k..we aren't using for loop because 
		//we don't know, where we need to call recursion,
		//so as we are using while loop we have to use count
		
		while(current!=null && count<=k) {
			next=current.next;
			//it will return head every time when we add a node to begin of the list
			newHeadReceived=addToBegin(newHeadReceived,current);
			current=next;
			count++;
		}
		
		//at last if still elements exists or list exists for further reversing
		//we make recursive call
		if(next!=null) {
			//return head of the list after reversing k elements
			Node receivedHead=reverseList(next,k);
			//linking of both list new head and previous tail
			head.next=receivedHead;
			receivedHead.prev=head;
		}
		
		return newHeadReceived;
		
	}
	
	//add received node to begin
	static Node addToBegin(Node head,Node current) {
		current.prev=null;
		current.next=null;
		
		if(head==null) {
			head=current;
			return head;
		}
		
			current.next=head;
			head.prev=current;
			head=current;
			
		return head;
	}
	
	
}
