package question18;

public class MainClass {
	public static void main(String args[]) {
		Node root=new Node(1);
		
		root.left=new Node(2);
		root.right=new Node(7);
		
		root.left.left=new Node(3);
		root.left.right=new Node(6);
		
		root.right.left=new Node(8);
		root.right.right=new Node(9);
		
		root.left.left.left=new Node(4);
		root.left.right.left=new Node(5);
		
		
		printLeaf(root);
	}
	
	static void printLeaf(Node node) {
		
		if(node==null) {
			return;
		}
		
		if(node.left==null && node.right==null) {
			System.out.println(node.data);
			return;
		}
		
		printLeaf(node.left);
		printLeaf(node.right);
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