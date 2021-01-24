package question23;

/*
 we will make use of LCA,that help us to find common peek in between both nodes
 after that its simple, we will find both node distances from that common(LCA)
 and add them,that it, as talking about minimum,it will be the minimum,
 else it always contain unique values,so there's no chance of another path possible
 */
public class UsingLCA {
	
	//O(n) time						O(1) space
	static int node1Distance=0;
	static int node2Distance=0;
	
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(7);
		
		tree.root.left.left=new Node(3);
		tree.root.left.right=new Node(4);
		tree.root.left.right.left=new Node(5);
		
		tree.root.right.right=new Node(9);
		
		
		int node1=5;
		int node2=9;
		
		Node common=findLCA(tree.root,node1,node2);
		findDistance(common,node1,true,node1Distance);
		findDistance(common,node2,false,node2Distance);
		
		System.out.println(node1Distance+node2Distance);
	}
	
	//boolean node1Path --just to indicate it's node1 or node2,to update global variable
	static void findDistance(Node node,int destination,boolean node1Path,int dist) {
		if(node==null) {
			return;
		}
		
		//we aren't backtracking so we take global variable,
		//else if do backtracking then we need to return by adding
		//and at last need to -2 from final result,bcz we have added root path both time
		if(node.data==destination) {
			if(node1Path) {
				node1Distance=dist;
			}else {
				node2Distance=dist;
			}
		}
		
		
		findDistance(node.left,destination,node1Path,dist+1);
		findDistance(node.right,destination,node1Path,dist+1);
		
	}
	
	//LCA code
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
