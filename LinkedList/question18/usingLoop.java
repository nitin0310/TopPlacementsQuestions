package question18;

public class usingLoop {
	//  O(n)  --time  		O(1)  --space
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		list.addNode(3);
		list.addNode(3);
		list.addNode(3);
		list.print();
		list.removeDuplicates();
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
	
	void removeDuplicates() {
		if(head==null || head.next==null) {
			System.out.println("Nothing to remove");
		}else {
			Node temp=head.next;
			Node prev=head;

			while(temp!=null) {
				if(temp.data==prev.data) {
					prev.next=temp.next;
					temp=temp.next;
				}else {
					prev=temp;
					temp=temp.next;
				}
			}
			
		}
	}
	
}