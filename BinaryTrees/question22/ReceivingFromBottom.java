package question22;

public class ReceivingFromBottom {
	//O(n) time							O(1) space
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		System.out.println((findLCA(tree.root,2,5)).data);
	}
	
	/*
	 LCA---lowest(not by value,by level or depth) parent jo dono me common ho
	 
	 basically we are going down and when we found any of the node, matching
	 then we return that node and backtrack
	 
	 if both nodes are in left right, then at LCA we receive from both side
	 
	 if they exist one node child of other,then at backtrack that parent returned
	 from one side and null from other side then finally that parent received from function at last
	 that is the LCA
	 */
	static Node findLCA(Node node,int node1,int node2) {
		if(node==null) {
			return null;
		}
		
		if(node.data==node1) {
			return node;
		}
		
		if(node.data==node2) {
			return node;
		}
		
		Node left=findLCA(node.left,node1,node2);
		Node right=findLCA(node.right,node1,node2);
		
		if(left!=null && right!=null) {
			return node;
		}
				
		if(left!=null || right!=null) {
			if(left!=null) {
				return left;
			}else {
				return right;
			}
		}
		
		return null;
	}
}
