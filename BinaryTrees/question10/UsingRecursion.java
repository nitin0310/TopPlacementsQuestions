package question10;

public class UsingRecursion {
	//O(n) time						O(1) space
	public static void main(String args[]) {
		Tree tree=new Tree(10);
		
		tree.root.left=new Node(-2);
		tree.root.right=new Node(6);
		
		tree.root.left.left=new Node(8);
		tree.root.left.right=new Node(-4);
		
		tree.root.right.left=new Node(7);
		tree.root.right.right=new Node(5);
		
		transformToSumTree(tree.root);
		inOrderTraversal(tree.root);
	}
	
	static int transformToSumTree(Node node) {
		
		if(node.left==null && node.right==null) {
			int value=node.data;
			node.data=0;
			return value;
		}
		
		//here we are considering, that every parent node must have both children
		int leftSum=transformToSumTree(node.left);
		int rightSum=transformToSumTree(node.right);
		
		int value=node.data;
		node.data=leftSum+rightSum;
		
		return node.data+value;//bcz as in tree we have to add that previous node value as well but in its parent so we are adding it and returning it
	}
	
	static void inOrderTraversal(Node node) {
		if(node==null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
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