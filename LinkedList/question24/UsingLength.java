package question24;

//most important question and thing --check for same address 
//bcz data can be same but not linked

public class UsingLength {
	//O(n+m) --time 	O(1) --space
	public static void main(String args[]) {
		SinglyLinkedList list1=new SinglyLinkedList();
		SinglyLinkedList list2=new SinglyLinkedList();
		
		list1.addNode(3);
		list1.addNode(4);
		list1.addNode(9);
		list1.addNode(15);
		list1.addNode(30);
		list1.print();
		
		list2.addNode(10);
		list2.head.next=list1.head.next.next.next;
		list2.print();
		
		System.out.println(list1.length);
		System.out.println(list2.length);
		
		System.out.println("Intersection point : "+SinglyLinkedList.findIntersectionPoint(list1, list2));
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
	int length=0;
	
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
				length++;
			}
			System.out.println();
		}
	}

	static int findIntersectionPoint(SinglyLinkedList list1,SinglyLinkedList list2) {
		if(list1.length==0 || list2.length==0) {
			return -1;
		}else {
			int difference = Math.abs(list1.length-list2.length);
			Node temp1=list1.head;
			Node temp2=list2.head;
			if(list1.length>list2.length) {
				for(int i=0;i<difference;i++) {
					temp1=temp1.next;
				}
				
				while(temp1!=null && temp2!=null) {
					if(temp1.data==temp2.data) {
						return temp1.data;
					}
					temp1=temp1.next;
					temp2=temp2.next;
				}
				return -1;
			}else {
				for(int i=0;i<difference;i++) {
					temp2=temp2.next;
				}
				
				while(temp1!=null && temp2!=null) {
					if(temp1==temp2) {				//address compared
						return temp2.data;
					}
					temp1=temp1.next;
					temp2=temp2.next;
				}
				return -1;
			}
		}
	}
}
