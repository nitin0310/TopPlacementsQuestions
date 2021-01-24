package basic;

public class CheckIsBST {
	public static void main(String args[]) {
		Tree tree2=new Tree(13);
		tree2.root.left=new Node(9);
		tree2.root.right=new Node(17);
		
		tree2.root.left.right=new Node(11);
		tree2.root.left.right.left=new Node(7);
		tree2.root.right.left=new Node(16);
		tree2.root.right.right=new Node(19);
		
		tree2.root.right.left.left=new Node(12);
		tree2.root.right.left.right=new Node(24);
		
		//at initial we are initializing with min and max as -infinity to infinity
		System.out.println(isBst(tree2.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
	
	//we are usually defining the ranges for a element at a node,using parent node
	static boolean isBst(Node node,int min,int max) {
		if(node==null) {
			return true;
		}
		
		if(node.data<min || node.data>max) {
			return false;
		}
		//		left subtree					  right subtree
		return (isBst(node.left,min,node.data) && isBst(node.right,node.data,max));
	}
	
	//usually it is reaching till last i.e leaf node and return true from there but
	//if in-between path we found any of the condition voilating then it will gonna
	//the result to false,that's why we are using && operator
	
	//reference--myCodeSchool youtube
}
