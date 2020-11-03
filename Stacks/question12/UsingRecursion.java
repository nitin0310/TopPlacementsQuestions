package question12;
import java.util.*;

public class UsingRecursion {
	//Level order traversal in spiral form
	public static void main(String[] args) {
		Tree tree=new Tree();
		Node root=tree.createNode(1);
		root.left=tree.createNode(2);
		root.right=tree.createNode(3);
		root.left.left=tree.createNode(7);
		root.left.right=tree.createNode(6);
		root.right.left=tree.createNode(5);
		root.right.right=tree.createNode(4);
		
		tree.levelOrderTraversalReverse(root);
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

class Tree{
	
	Node root=null;
	
	Node createNode(int data) {
		Node newnode=new Node(data);
		
		if(root==null) {
			root=newnode;
			return root;
		}else {
			return newnode;
		}
	}
	
	void levelOrderTraversalReverse(Node root) {
		Stack<Node> stack1=new Stack<Node>();
		Stack<Node> stack2=new Stack<Node>();
		
		//at initial we are inserting in stack2 to run while loop
		stack2.push(root);
		//ye loop lo chalaye rakhega end tk
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			//ye left to right print krne me help krega
			while(!stack2.isEmpty()) {
				if(stack2.peek().right!=null) {
					stack1.push(stack2.peek().right);
				}
				if(stack2.peek().left!=null) {
					stack1.push(stack2.peek().left);
				}
				System.out.println(stack2.pop().data);
			}
			
			//ye right to left print krne me help krega
			while(!stack1.isEmpty()) {
				if(stack1.peek().left!=null) {
					stack2.push(stack1.peek().left);
				}
				if(stack1.peek().right!=null) {
					stack2.push(stack1.peek().right);
				}
				System.out.println(stack1.pop().data);
			}
			
		}
	}
}
