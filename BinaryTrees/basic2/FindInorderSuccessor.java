package basic2;

//O(h) time					O(1) space
/*
 simple philosophy,
 --inorder successor right me hi hoga mainly,so check for min. element in right sub tree
 --else agar right subtree  ==null
 --then go for left sub tree but here is something,
 left sub tree me us node ka right node exist krta hai to obvious whi inorder successor hoga
 but aga nhi krta to parent hoga,jiske left subtree me ye node exist krta hai
 ..that's it
 */
public class FindInorderSuccessor {
	public static void main(String args[]) {
		Tree tree = new Tree(20);
		
		tree.insertNode(8);
		tree.insertNode(22);
		
		tree.insertNode(4);
		tree.insertNode(12);
		
		tree.insertNode(10);
		tree.insertNode(14);
		
		inorderTraversal(tree.root);
		System.out.println();
		findInorder(tree.root,8);
		findInorder(tree.root,10);
	}
	
	static void inorderTraversal(Node node) {
		if(node==null) {
			return;
		}
		
		inorderTraversal(node.left);
		System.out.print(node.data+" ");
		inorderTraversal(node.right);
	}
	
	static void findInorder(Node node,int data) {
		
		Node askedNode=reachNode(node,data);//help us to reach to that element for which we need to find inorder successor
		
		if(askedNode.right!=null) {//if right sub tree is present, find min from it
			Node temp=findMin(askedNode.right);//imp: must send it's right node reference, not that node
			System.out.println("inorder successor : "+temp.data);
		}else {
			//to keep track of parent,we modified node structure,
			//to keep track for left subtree and that parent we are using variables, parent and current
			Node parent=askedNode.parent;
			Node current=askedNode;
			while(parent.left!=current) {
				current=parent;
				parent=parent.parent;
			}
			
			System.out.println("inorder successor : "+parent.data);
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
	static Node findMin(Node node) {
		Node temp=node;
		while(temp.left!=null) {
			temp=temp.left;
		}
		
		return temp;
	}
}

class Tree{
	Node root;
	
	Tree(int data){
		root=new Node(data);
	}
	
	void insertNode(int data) {
		if(root==null) {
			root = new Node(data);
		}else {
			Node newNode=new Node(data);
			Node temp=root;
			Node prev=root;
			
			while(temp!=null) {
				prev=temp;
				if(newNode.data<temp.data) {
					newNode.parent=temp;//updating parent node with loop
					temp=temp.left;
				}else {
					newNode.parent=temp;//updating parent node with loop
					temp=temp.right;
				}
			}
			
			if(newNode.data<prev.data) {
				prev.left=newNode;
			}else {
				prev.right=newNode;
			}
		}
	}
	
}

class Node{
	Node left;
	Node right;
	Node parent;
	int data;
	
	Node(int data){
		this.data=data;
	}
}