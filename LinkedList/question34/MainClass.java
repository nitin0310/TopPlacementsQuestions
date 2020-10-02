package question34;
import java.io.*;

public class MainClass {
	//find pairs of target sum  --sorted linked list
	//can't use dp bcz expected time - O(n)
	//can make use of its already sorted
	//as we know pair made by values one from start and one from end side
	//O(n) --time 		O(1) --space
	
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		DoublyLinkedList list=new DoublyLinkedList();
		list.addNode(1);
		list.addNode(2);
		list.addNode(4);
		list.addNode(5);
		list.addNode(6);
		list.addNode(8);
		list.addNode(9);
		list.print();
		System.out.println("Enter value : ");
		int x=Integer.parseInt(br.readLine());
		list.printPairs(x);
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
	
	void printPairs(int value) {
		if(head==null || head.next==null) {
			System.out.println("Can't make pairs");
		}else {
			Node start=head;
			Node end;
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			end=temp;
			
			while(start.data<end.data) {
				if(end.data>value) {
					end=end.prev;
				}
				
				if(start.data+end.data==value) {
					System.out.println(start.data+","+end.data);
					start=start.next;
					end=end.prev;
				}else {
					//obvious sum less hai then use reach krane k liye value start
					//se badhani pdegi
					if((start.data+end.data)<value) {
						start=start.next;
					}else {
						end=end.prev;
					}
				}
			}
		}
	}
	
}
