package question12;
import java.util.Stack;

public class HalfReversing {//O(n) --time	O(1) --space
	
	public static void main(String args[]) {
		SinglyLinkedList1 list=new SinglyLinkedList1();
		list.addNode(1);
		list.addNode(2);
		list.addNode(2);
		list.addNode(1);
		list.print();
		System.out.println("Check palindrome : "+list.checkPalindrome());
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
	int length=0;
	
	void addNode(int data) {
		length++;
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
	
	boolean checkPalindrome() {
		Node1 temp1=head;
		Node1 temp2 = length%2==0?checkWhenEven(length/2):checkWhenOdd((length/2)+1);
		for(int i=1;i<=length/2;i++) {
			if(temp1.data!=temp2.data)
				return false;
			
			temp1=temp1.next;
			temp2=temp2.next;
		}
		return true;
	}
	
	Node1 reverseList(Node1 node) {
		Node1 prev=null,current=node,next=current.next;
		while(next!=null) {
			current.next=prev;
			prev=current;
			current=next;
			next=next.next;
		}
		current.next=prev;
		return current;
	}
	
	Node1 checkWhenEven(int n) {
		Node1 temp=head;
		for(int i=1;i<=n;i++) {
			temp=temp.next;
		}
		return reverseList(temp);
	}
	
	Node1 checkWhenOdd(int n) {
		Node1 temp=head;
		for(int i=1;i<=n;i++) {
			temp=temp.next;
		}
		return reverseList(temp);
	}
	
}