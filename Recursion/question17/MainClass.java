package question17;

public class MainClass {
	public static void main(String args[]) {
		Node head=new Node(9);
		head.next=new Node(8);
		head.next.next=new Node(3);
		head.next.next.next=new Node(5);
		head.next.next.next.next=new Node(2);
		head.next.next.next.next.next=new Node(1);
		int n=6;
		lengthGiven(head,1,n%2==0?n/2:n/2+1);//odd or even
		lengthNotGiven(head,1,n%2==0?n/2:n/2+1);
	}
	
	static void lengthGiven(Node node,int count,int target) {
		
		if(count==target) {
			System.out.println(node.data);
			return;
		}
		lengthGiven(node.next,count+1,target);
	}
	
	static void lengthNotGiven(Node node,int count,int target) {
		if(node==null) {
			return;
		}//reach till end with incrementing count,usually its calculating length
		
		lengthGiven(node.next,count+1,target);
		if(count-1==target) {
			System.out.println(node.data);
		}
	}
}

class Node{
	Node next;
	int data;
	
	Node(int data){
		this.data=data;
	}
}
