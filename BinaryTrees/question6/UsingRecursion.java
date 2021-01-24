package question6;

public class UsingRecursion {
	//O(n^2) time						O(1) space
	static int preIndex=0;
	
	public static void main(String args[]) {
		int[] inOrder = {3,1,4,0,5,2};
		int[] preOrder = {0,1,3,4,2,5};
		int length=6;
		
		Tree tree=new Tree();
		tree.root=buildTree(inOrder,preOrder,0,length-1);
		postOrderTraversal(tree.root);
	}
	
	//here one thing we need to note down is---
	//we are picking values from postOrder one by one and creating tree with it
	//but inOrder is helping us to keep track for left and right sub trees,using start and end index
	static Node buildTree(int[] inOrder,int[] preOrder,int start,int end) {
		
		//if start>end nothing to add to that tree
		if(start>end) {
			return null;
		}
		
		Node node = new Node(preOrder[preIndex++]);//creating node
		
		if(start==end) {//if node doesn't have left and right child
			return node;
		}
		
		//finding index,now left values to this index is of left sub tree,right values is of right sub tree
		int index=searchIndex(inOrder,start,end,node.data);
		
		//making call to build left sub tree and return it's root to connect to its node.left
		node.left=buildTree(inOrder,preOrder,start,index-1);
		//making call to build right sub tree and return it's root to connect to its node.right
		node.right=buildTree(inOrder,preOrder,index+1,end);
		
		return node;
	}
	
	static int searchIndex(int[] inOrder,int start,int end,int data) {
		int i;
		for(i=start;i<=end;i++) {
			if(inOrder[i]==data) {
				return i;
			}
		}
		
		return i;
	}
	
	static void postOrderTraversal(Node node) {
		if(node==null) {
			return;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data+" ");
	}
}

class Tree{
	Node root;
}

class Node{
	Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data=data;
	}
}