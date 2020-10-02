package question15;
import java.util.*;

public class ByModifyingValues {
	public static void main(String args[]) {
		//when we visit a node we mark or update it with MAX or MIN
		//if there is a loop then surely it will encounter visited
		//then we return true.
		
		//O(n) --time  		O(1) --space
		SinglyLinkedList1 list=new SinglyLinkedList1();
		list.addNode(20);
		list.addNode(4);
		list.addNode(15);
		list.addNode(10);
		list.print();
		list.head.next.next.next.next=list.head;
		System.out.println(list.checkLoop());
		
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
		length++;
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
	
	boolean checkLoop() {
		
		Node1 temp=head;
		while(temp!=null) {
			if(temp.data==Integer.MAX_VALUE) {
				return true;
			}
			temp.data=Integer.MAX_VALUE;
			temp=temp.next;
		}
		return false;
	}
}