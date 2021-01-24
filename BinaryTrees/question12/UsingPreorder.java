package question12;

public class UsingPreorder {
	//O(n) time--preOrder traversal				O(1) space
	//we are using the fact that pe order traversal works as left right root,
	//our sum requires that exactly
	
	static boolean flag=true;
	public static void main(String args[]) {
		Tree tree=new Tree(10);
		
		tree.root.left=new Node(20);
		tree.root.right=new Node(30);
		
		tree.root.left.left=new Node(10);
		tree.root.left.right=new Node(10);
		
		preOrder(tree.root);
		System.out.println(flag);
	}
	
	//by default flag true hoga ,agar puri process me condition false hui,i mean sum tree nhi hua to 
	//flag = false kr denge and ise dobara true krne ki condition nhi hogi,that's it
	static int preOrder(Node node) {
		if(node==null) {//if no element or parent node with single child element
			return 0;
		}
		
		if(node.left==null && node.right==null) {//no child
			return node.data;
		}
		
		int left=preOrder(node.left);
		int right=preOrder(node.right);
		
		if(left+right!=node.data) {//validating condition
			flag=false;
		}
		
		return left+right+node.data;
	}
}
