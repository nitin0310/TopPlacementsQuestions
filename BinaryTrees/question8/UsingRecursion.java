package question8;

import java.util.Stack;

public class UsingRecursion {
	static int traverser=0;
	static Node root;
	
	public static void main(String[] args) {
		
		String string="4";
		buildTree(string,root);
		inOrder(root);
		
	}

	static void buildTree(String string,Node root) {
		if(string.isEmpty()) {
			return;
		}
		
		Stack<Node> stack=new Stack<Node>();
		
		while(traverser<string.length()) {
			if(string.charAt(traverser)!='(' && string.charAt(traverser)!=')') {
				Node node=new Node(Character.getNumericValue(string.charAt(traverser)));
				
				if(traverser==0) {
					root=node;
				}
				if(!stack.isEmpty()) {
					Node top=stack.peek();
					if(top.left!=null) {
						top.left=node;
					}else {
						top.right=node;
					}
				}
				stack.push(node);
				traverser++;
			}else {
				if(string.charAt(traverser)=='(') {
					traverser++;
				}else {
					if(!stack.isEmpty()) {
						stack.pop();
					}
					traverser++;
				}
			}
		}
		
		
	}
	
	static void inOrder(Node node) {
		if(node==null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
}

class Tree{
	Node root;
}

class Node{
	Node left;
	Node right;
	int data;
	
	Node (int data){
		this.data=data;
	}
}