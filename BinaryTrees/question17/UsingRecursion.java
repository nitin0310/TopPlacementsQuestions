package question17;

public class UsingRecursion {
	//sum tree variation
	//O(n) time								O(1) space
	static int maxSum=Integer.MIN_VALUE;
	
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		tree.root.left=new Node(-2);
		tree.root.right=new Node(3);
		
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		tree.root.right.left=new Node(-6);
		tree.root.right.right=new Node(2);
		
		findMaxSumTree(tree.root);
		System.out.println(maxSum);
	}
	
	static int findMaxSumTree(Node node) {
		if(node==null) {
			return 0;
		}
		
		if(node.left==null && node.right==null) {
			return node.data;
		}
		
		int left=findMaxSumTree(node.left);
		int right=findMaxSumTree(node.right);
		
		if(left+right+node.data>maxSum) {
			maxSum=left+right+node.data;
		}
		
		return left+right+node.data;
	}
}
