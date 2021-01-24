package question13;

public class UsingRecursion {
	//O(n) time							O(1) space
	static boolean visitedAnyLeafYet = false;
	static int levelOfAnyLeaf=0;
	
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
//		tree.root.right.right=new Node(4);
		
		System.out.println(checkLeafNodeLevel(tree.root,0));
	}
	
	static boolean checkLeafNodeLevel(Node node,int index) {
		if(node==null) {
			return true;
		}
		
		if(node.left==null && node.right==null) {
			if(visitedAnyLeafYet && levelOfAnyLeaf!=index) {
				return false;
			}else {
				visitedAnyLeafYet=true;
				levelOfAnyLeaf=index;
				return true;
			}
		}
		
		return (checkLeafNodeLevel(node.left,index-1) && checkLeafNodeLevel(node.right,index-1));
		
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