package question16;

public class UsingRecursion {
	//O(n) time						O(1) space
	static int maxLevel=1;
	static int maxSum=Integer.MIN_VALUE;
	
	public static void main(String args[]) {
		
		Tree tree = new Tree(4);         	  /*        4        */
		tree.root.left = new Node(2);         /*       / \       */
		tree.root.right = new Node(5);        /*      2   5      */
		tree.root.left.left = new Node(7);    /*     / \ / \     */
		tree.root.left.right = new Node(1);   /*    7  1 2  3    */
		tree.root.right.left = new Node(2);   /*      /          */
		tree.root.right.right = new Node(3);  /*     6           */
		tree.root.left.right.left = new Node(6);
		
		preOrder(tree.root,0,0);
		System.out.println("maxLevel : "+maxLevel+" sum : "+maxSum);
	}
	
	static void preOrder(Node node,int level,int sum) {
		if(node==null) {
			return;
		}
		
		if(level<=maxLevel) {
			maxLevel=level;
			maxSum=max(maxSum,sum+node.data);
			
		}
		preOrder(node.left,level-1,sum+node.data);
		preOrder(node.right,level-1,sum+node.data);
		
	}
	
	static int max(int a,int b) {
		return a>b?a:b;
	}
}
