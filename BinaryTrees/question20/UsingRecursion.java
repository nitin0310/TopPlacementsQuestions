package question20;

public class UsingRecursion {
	//O(n) time							O(1) space
	static int k;
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		k=2;
		if(findKthAncestor(tree.root,4)!=null) {
			System.out.println(-1);
		}
	}
	
	static Node findKthAncestor(Node node,int data) {
		if(node==null) {
			return null;
		}
		
		//this is a good calling approach,when we have to make call for both side,but
		//in any recursion call we are done with out work and we don't want further calls,
		//we can use this technique using or condition recursive calls
		if(node.data==data || findKthAncestor(node.left,data)!=null || findKthAncestor(node.right,data)!=null) {
			if(k>0) {
				k--;
			}else if(k==0) {
				System.out.println(node.data);
				return null;
			}
			
			return node;
		}
		
		return null;
	}
}
