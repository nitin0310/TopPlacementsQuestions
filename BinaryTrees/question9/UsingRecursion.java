package question9;

/*
 we need to do simple thing,
 finding inorder predecessor(right most element in left subtree)
 finding inorder successor(left most element in right subtree)
 
 and doing this recursively,
 linking root to predecessor and linking predecessor to root
 and
 linking root to successor and linking successor to root
 */
public class UsingRecursion {
	//O(h^2) somewhere near to it				O(1) space
	public static void main(String args[]) {
		Tree tree=new Tree(10);
		
		tree.root.left=new Node(20);
		tree.root.right=new Node(30);
		
		tree.root.left.left=new Node(40);
		tree.root.left.right=new Node(60);
		
		
	}
	
	static void convert(Node node,Node parent) {
		
		
		Node receivedPredecessor=findInorderPredecessor(node.left);
		receivedPredecessor.right=parent;
		node.left=receivedPredecessor;
		
		
		Node receivedSuccessor=findInorderSuccessor(node.right);
		receivedSuccessor.left=parent;
		parent.right=receivedSuccessor;
	}
	
	static Node findInorderPredecessor(Node node) {
		
		if(node==null) {
			return null;
		}
		if(node.left==null && node.right==null) {
			return node;
		}
		
		return findInorderPredecessor(node.right);
	}
	
	static Node findInorderSuccessor(Node node) {
		if(node==null) {
			return null;
		}
		if(node.left==null && node.right==null) {
			return node;
		}
		
		return findInorderSuccessor(node.left);
	}
	
}