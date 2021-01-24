package question5;

public class MainClass {
	public static void main(String args[]) {
		Tree tree=new Tree(20);
        tree.root.left = new Node(8); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        tree.root.right = new Node(22); 
        tree.root.right.right = new Node(25);
        
        boundaryTraversal(tree.root);
	}
	
	static void boundaryTraversal(Node node) {
		if(node==null) {
			return;
		}
		
		System.out.print(node.data+" ");//printing root
		printLeftNodes(node.left);//printing all left boundary nodes
		
		printLeafNodes(node.left);//to print half left side leaf nodes
		printLeafNodes(node.right);//to print half right side leaf nodes
		
		printRightNodes(node.right);//printing all right boundary nodes
	}
	
	static void printLeftNodes(Node node) {
		if(node==null) {
			return;
		}
		
		if(node.left!=null) {
			//if it have left node then print that node and move further to left
			System.out.print(node.data+" ");
			printLeftNodes(node.left);
			
		}else if(node.right!=null) {
			//if it doesn't have left node but have right node then for sure it must be next node of left boundary
			System.out.print(node.data+" ");
			printLeftNodes(node.left);
		}
	}
	
	//every time it must start from left bcz as we are printing from start or half we have to print from left to right(anti clock wise)
	static void printLeafNodes(Node node) {
		if(node==null) {
			return;
		}
		
		//first go to as left as possible to starting point of the leaf node
		printLeafNodes(node.left);
		//leaf node must have left and right node as null
		if(node.left==null && node.right==null) {
			System.out.print(node.data+" ");
			return;
		}
		
		//it helps us to move to the right side after printing leaf nodes of left sides
		printLeafNodes(node.right);
	}
	
	static void printRightNodes(Node node) {
		if(node==null) {
			return;
		}
		
		if(node.right!=null) {
			//if it have right node then print that node and move further to right
			printRightNodes(node.right);
			System.out.print(node.data+" ");
			
		}else if(node.left!=null) {
			//if it doesn't have right node but have left node then for sure it must be next node of right boundary
			printRightNodes(node.right);
			System.out.print(node.data+" ");
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