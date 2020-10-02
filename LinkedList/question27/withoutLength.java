package question27;

public class withoutLength {
	//O(n) --time
	public static void main(String[] args) {
		SinglyLinkedList1 list=new SinglyLinkedList1();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.print();
		System.out.println(list.findMiddleElement());
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
	
	int findMiddleElement() {
		if(head==null)
			return Integer.MIN_VALUE;
		
		Node1 slow=head;
		Node1 fast=head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
}
