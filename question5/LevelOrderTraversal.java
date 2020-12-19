package question5;
import java.util.*;

public class LevelOrderTraversal {
	public static void main(String args[]) {
		BinarySearchTree instance = new BinarySearchTree();
		instance.addNode(10);
		instance.addNode(5);
		instance.addNode(12);
		instance.addNode(7);
		instance.addNode(11);
		instance.addNode(15);
		instance.addNode(6);
		
		instance.lOTraversal();
	}
}

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
	}
}

class BinarySearchTree{
	
	Node root;
	
	void addNode(int data) {
		Node newnode = new Node(data);
		
		//can also be done using recursion
		if(root==null) {
			root=newnode;
		}else {
			Node temp=root;
			Node temp2=temp;
			while(temp!=null) {
				temp2=temp;
				if(data<temp.data) {
					temp=temp.left;
				}else {
					temp=temp.right;
				}
			}
			
			if(data<temp2.data) {
				temp2.left=newnode;
			}else {
				temp2.right=newnode;
			}
		}
	}
	
	void lOTraversal() {
		if(root==null) {
			return;
		}else {
			Queue<Node> queue = new LinkedList<Node>();
			Node temp=root;
			queue.add(temp);
			
			while(!queue.isEmpty()) {
				temp=queue.remove();
				System.out.print(temp.data+" ");
				
				if(temp.left!=null) {
					queue.add(temp.left);
				}
				
				if(temp.right!=null) {
					queue.add(temp.right);
				}
			}
		}
	}
}
