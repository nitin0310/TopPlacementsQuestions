package question3;

import java.util.*;

public class Using2Stacks {
	//O(n) time						O(n) space
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.left=new Node(7);
		tree.root.left.right=new Node(6);
		tree.root.right.left=new Node(5);
		tree.root.right.right=new Node(4);
		
		Stack<Node> stack1=new Stack<Node>();
		Stack<Node> stack2=new Stack<Node>();
		stack1.push(tree.root);
		levelOrderSpiral(stack1,stack2,true);
	}
	
	static void levelOrderSpiral(Stack<Node> stack1,Stack<Node> stack2,boolean flag) {
		
		if(stack1.isEmpty() && stack2.isEmpty()) {//base cond. when our tree must have to stop,bcz nothing to print or check in stack
			return;
		}
		
		//we are making use of flag, to indicate whether we need to go left->right or right->left
		if(flag) {
			while(!stack1.isEmpty()) {
				Node topNode=stack1.pop();
				System.out.print(topNode.data+" ");
				
				if(topNode.right!=null) {
					stack2.push(topNode.right);
				}
				if(topNode.left!=null) {
					stack2.push(topNode.left);
				}
			}
		}else {
			while(!stack2.isEmpty()) {
				Node topNode=stack2.pop();
				System.out.print(topNode.data+" ");
				
				if(topNode.left!=null) {
					stack1.push(topNode.left);
				}
				if(topNode.right!=null) {
					stack1.push(topNode.right);
				}
				
			}
		}
		
		levelOrderSpiral(stack1,stack2,!flag);
	}
}

class Tree{
	Node root;
	Tree(int data){
		root=new Node(data);
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