package basic2;

//O(h) time				O(1) space
public class FindInorderPredecessor {
	public static void main(String args[]) {
		Tree tree2=new Tree(20);
		
		tree2.insertNode(17);
		tree2.insertNode(31);
		
		tree2.insertNode(19);
		tree2.insertNode(26);
		tree2.insertNode(36);
		
		tree2.insertNode(22);
		
		inorderTraversal(tree2.root);
		System.out.println();
		findInorderPred(tree2.root,22);
		findInorderPred(tree2.root,31);
		
	}
	
	static void inorderTraversal(Node node) {
		if(node==null) {
			return;
		}
		
		inorderTraversal(node.left);
		System.out.print(node.data+" ");
		inorderTraversal(node.right);
	}
	
	static void findInorderPred(Node node,int data) {
		
		Node askedNode=reachNode(node,data);//help us to reach to that element for which we need to find inorder predecessor
		
		if(askedNode.left!=null) {//if left sub tree is present, find max from it
			Node temp=findMax(askedNode.left);//imp: must send it's left node reference, not that node
			System.out.println("inorder predecessor : "+temp.data);
		}else {
			//to keep track of parent,we modified node structure,
			//to keep track for left subtree and that parent we are using variables, parent and current
			Node parent=askedNode.parent;
			Node current=askedNode;
			while(parent.right!=current) {
				current=parent;
				parent=parent.parent;
			}
			
			System.out.println("inorder predecessor : "+parent.data);
		}
	}
	
	//simple traversal to reach that node
		static Node reachNode(Node node,int key) {
			Node reached;
			
			if(node.data==key) {
				return node;
			}
			
			if(key<node.data) {
				reached=reachNode(node.left,key);
			}else {
				reached=reachNode(node.right,key);
			}
			
			return reached;
		}
		
		//go to as left as possible, bcz it's a bst
		static Node findMax(Node node) {
			Node temp=node;
			while(temp.right!=null) {
				temp=temp.right;
			}
			
			return temp;
		}
}
