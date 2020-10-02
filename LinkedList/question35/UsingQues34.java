package question35;

public class UsingQues34 {

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
