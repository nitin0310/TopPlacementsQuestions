package question16;

public class UsingLoop {
	//O(n)  --time  		O(1)  --space
	public static void main(String args[]) {
		SinglyLinkedList1 list=new SinglyLinkedList1();
		list.addNode(1);
		list.addNode(2);
		list.addNode(3);
		list.addNode(4);
		list.addNode(5);
		
		//loop created
		list.head.next.next.next.next.next=list.head.next;
		// 5 linked to 2
		System.out.println("length of loop : "+list.findLoopLength());
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
	
	Node1 checkLoop() {
		
		Node1 temp=head;
		Node1 prev=head;
		while(temp!=null) {
			if(temp.data==Integer.MAX_VALUE) {
				prev.next=null;
				return temp;
			}
			temp.data=Integer.MAX_VALUE;
			prev=temp;
			temp=temp.next;
		}
		return null;
	}
	
	int findLoopLength() {
		Node1 receivedNode = checkLoop();
		int count=0;
		if(receivedNode != null) {
			while(receivedNode!=null) {
				count++;
				receivedNode = receivedNode.next;
			}
			return count;
		}else {
			return 0;
		}
	}
}