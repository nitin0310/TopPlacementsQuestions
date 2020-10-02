package question23;

public class usingLoop {
	//O(n+m) --time 		O(n+m) --space
	//better than using hash map with no list loss
	public static void main(String args[]) {
		SinglyLinkedList1 list1 = new SinglyLinkedList1();
		SinglyLinkedList1 list2 = new SinglyLinkedList1();
		SinglyLinkedList1 output = new SinglyLinkedList1();
		
		list1.addNode(4);
		list1.addNode(6);
		list1.addNode(7);
		list1.addNode(9);
		list1.addNode(10);
		list1.print();
		
		list2.addNode(6);
		list2.addNode(8);
		list2.addNode(9);
		list2.addNode(11);
		list2.print();
		
		output.findIntersectingElements(list1, list2, output);
		output.print();
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
	
	
	void findIntersectingElements(SinglyLinkedList1 list1,SinglyLinkedList1 list2,SinglyLinkedList1 output) {
		
		Node1 temp1=list1.head;
		Node1 temp2=list2.head;
		
		if(temp1==null || temp2==null) {
			System.out.println("Nothing common");
		}else {
			
			while(temp1!=null && temp2!=null) {
				if(temp1.data==temp2.data) {
					output.addNode(temp1.data);
					temp1=temp1.next;
					temp2=temp2.next;
				}else {
					if(temp1.data<temp2.data) {
						temp1=temp1.next;
					}else {
						temp2=temp2.next;
					}
				}
			}
			
		}
	}
	
	
}
