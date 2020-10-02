package question25;

public class MergeSort {
	
	//Most Important question ---total similar to standard array approach
	//O(n logn)
	
	public static void main(String args[]) {
		SinglyLinkedList list=new SinglyLinkedList();
		list.addNode(40);
		list.addNode(20);
		list.addNode(60);
		list.addNode(10);
		list.addNode(50);
		list.addNode(30);
		list.print(list.head);
		
		Node receivedHead = list.mergeSort(list.head);
		list.print(receivedHead);
		
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
	
	void print(Node head) {
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
	
	Node mergeSort(Node head) {
		
		if(head==null || head.next==null)
			return head;
		
		Node middleNode=getMiddle(head);
		Node nextToMiddle = middleNode.next;
		middleNode.next=null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextToMiddle);
		
		Node list=merge(left,right);
		return list;
	}
	
	static Node merge(Node left,Node right) {
		Node result=null;
		
		if(left==null)
			return right;
		if(right==null)
			return left;
		
		if(left.data<=right.data) {
			result = left;
			result.next = merge(left.next,right);
		}else {
			result = right;
			result.next = merge(left,right.next);
		}
		
		return result;
	}
	
	public static Node getMiddle(Node head) 
    { 
        if (head == null) 
            return head; 
  
        Node slow = head, fast = head; 
  
        while (fast.next != null && fast.next.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        return slow; 
    } 
  
	
}
