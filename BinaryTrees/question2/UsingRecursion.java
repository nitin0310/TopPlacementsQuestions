package question2;


public class UsingRecursion {
	//O(n) time						O(1) space
	static int count=0;
	public static void main(String args[]) {
		Tree2 tree=new Tree2(1);
		
		tree.root.left=new Node2(2);
		tree.root.right=new Node2(3);
		
		tree.root.left.right=new Node2(5);
		tree.root.left.right.left=new Node2(6);
		tree.root.left.right.right=new Node2(7);
		
		inOrder(tree.root,3);
	}
	
	static void inOrder(Node2 node,int n) {
		if(node==null) {
			return;
		}
		
		//here we need to focus one thing, that we will increase count when we have considered as part of inorder
		if(count<=n) {
			inOrder(node.left,n);
			count++;//it increases when it considered as inorder member
			
			if(count==n) {
				System.out.println(node.data);
				return;
			}
			
			inOrder(node.right,n);
		}
		
	}
	
}

class Tree2 {
	Node2 root;
	Tree2(int data){
		root = new Node2(data);
	}
}

class Node2{
	Node2 left;
	Node2 right;
	int data;
	
	Node2(int data){
		this.data=data;
	}
}