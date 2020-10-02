package question12;
import java.util.*;

public class UsingStacks {// O(n) --time		O(n) --space
	
	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(20);
		list.addNode(10);
		list.print();
		System.out.println("palindrome or not? : "+list.checkPalindrome());
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
	Stack<Integer> stack=new Stack<Integer>();
	
	Node head;
	
	void addNode(int data) {
		Node newnode = new Node(data);
		stack.push(data);
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
	
	boolean checkPalindrome() {
		if(head==null)
			return false;
		
		Node temp=head;
		while(temp!=null) {
			if(temp.data!=stack.pop()) {
				return false;
			}
			
			temp=temp.next;
		}
		return true;
	}
	
}