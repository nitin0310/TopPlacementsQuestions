package question4;
import java.util.*;

public class UsingQueue {
	//O(n) time				O(n) space
	public static void main(String args[]) {
		Tree tree=new Tree(8);
		
		tree.root.left=new Node(3);
		tree.root.right=new Node(10);
		
		tree.root.left.left=new Node(1);
		tree.root.left.right=new Node(6);
		
		tree.root.right.right=new Node(14);
		
		tree.root.left.right.left=new Node(4);
		tree.root.left.right.right=new Node(7);
		tree.root.right.right.left=new Node(13);
		
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(tree.root);
		diagonalTraversal(queue);
	}
	
	static void diagonalTraversal(Queue<Node> queue) {
		
		while(!queue.isEmpty()) {
			Node frontNode=queue.remove();//picking element at first
			
			//if it have node then we have to add it, bcz it will be in next diagonal
			//then, we have to go to right,but there's no need to add right in queue
			//so we are just updating it and printing
			while(frontNode!=null) {
				System.out.print(frontNode.data+" ");
				if(frontNode.left!=null) {
					queue.add(frontNode.left);
				}
				
				frontNode=frontNode.right;
			}
		}
	}
}

class Tree{
	Node root;
	Tree(int data){
		root=new Node(data);
	}
}

class Node{
	Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data=data;
	}
}