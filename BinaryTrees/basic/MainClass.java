package basic;
import java.util.*;

public class MainClass {
	public static void main(String args[]) {
		Tree tree=new Tree(13);
		tree.insertNode(2);
		tree.insertNode(4);
		tree.insertNode(17);
		tree.insertNode(14);
		tree.insertNode(16);
		
		tree.preOrderRecursion(tree.root);
		System.out.println();
		tree.preOrderIteration(tree.root);
		System.out.println();
		tree.inorderRecursion(tree.root);
		System.out.println();
		tree.inorderIteration(tree.root);
		System.out.println();
		tree.postOrderRecursion(tree.root);
		System.out.println();
		tree.postOrderIteration(tree.root);
		System.out.println();
		tree.levelOrderTraversal(tree.root);
		System.out.println();
		tree.searchValue(tree.root, 15);
		
		tree.findMin(tree.root);
		tree.findMax(tree.root);
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
					temp=temp.left;
				}else {
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
	
	void deleteNode(int data) {
		Node temp=root;
		Node prev=temp;
		
		while(temp!=null) {//reach to that node,and then check for other conditions
			prev=temp;
			if(temp.data==data) {
				return;
			}else if(data<temp.data) {
				temp=temp.left;
			}else {
				temp=temp.right;
			}
		}
		
		if(temp.left==null && temp.right==null) {//if have no child,directly remove--update it's parent
			if(prev.left==temp) {
				prev.left=null;
			}else {
				prev.right=null;
			}
		}else if(temp.left==null || temp.right==null) {//if have single child
			if(temp.left==null) {//if it is right child
				if(temp==prev.left) {
					prev.left=temp.right;
				}else {
					prev.right=temp.right;
				}
			}else {//if it is left child
				if(temp==prev.left) {
					prev.left=temp.left;
				}else {
					prev.right=temp.left;
				}
			}
		}else {//if have 2 children
			//now its choice to take biggest element from left or smallest element from right
			//we are taking smallest element from right
			
			
		}
	}
	
//----------------- root left right------------------------------
	void preOrderIteration(Node node) {//O(n) space approach,that's why we do with recursion
		Stack<Node> stack=new Stack<Node>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			Node topNode=stack.pop();
			System.out.print(topNode.data+" ");
			
			//we first store right,bcz it needs to come after left
			if(topNode.right!=null) {
				stack.push(topNode.right);
			}
			if(topNode.left!=null) {
				stack.push(topNode.left);
			}
		}
	}
	
	void preOrderRecursion(Node node) {
		if(node==null)
			return;
		
		System.out.print(node.data+" ");
		preOrderRecursion(node.left);
		preOrderRecursion(node.right);
	}
	
//----------------- left root right------------------------------
	void inorderIteration(Node node) {
		Stack<Node> stack=new Stack<Node>();
		Node temp=node;
		
		while(temp!=null || stack.size()>0) {
			
			while(temp!=null) {
				
				stack.push(temp);
				temp=temp.left;
			}
			
			temp=stack.pop();
			System.out.print(temp.data+" ");
			
			temp=temp.right;
		}
		
	}
	
	void inorderRecursion(Node node) {
		if(node==null)
			return;
		
		inorderRecursion(node.left);
		System.out.print(node.data+" ");
		inorderRecursion(node.right);
	}
	
//----------------- left right root------------------------------
	void postOrderRecursion(Node node) {
		if(node==null)
			return;
		
		postOrderRecursion(node.left);
		postOrderRecursion(node.right);
		System.out.print(node.data+" ");
	}
	
	void postOrderIteration(Node node) {
		Stack<Node> s1 = new Stack<>(); 
        Stack<Node> s2 = new Stack<>(); 
  
        if (root == null) 
            return; 
  
        // push root to first stack 
        s1.push(root); 
  
        // Run while first stack is not empty 
        while (!s1.isEmpty()) { 
            // Pop an item from s1 and push it to s2 
            Node temp = s1.pop(); 
            s2.push(temp); 
  
            // Push left and right children of 
            // removed item to s1 
            if (temp.left != null) 
                s1.push(temp.left); 
            if (temp.right != null) 
                s1.push(temp.right); 
        } 
  
        // Print all elements of second stack 
        while (!s2.isEmpty()) { 
            Node temp = s2.pop(); 
            System.out.print(temp.data + " "); 
        } 
		
	}
//*********************************************************************
	
	void levelOrderTraversal(Node node) {
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node temp=queue.remove();
			System.out.print(temp.data+" ");
			
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
	}
	
	void searchValue(Node node,int key) {
		
		if(node==null) {
			return;
		}
		
		if(node.data==key) {
			System.out.println("true");
			return;
		}
		
		if(key<node.data) {
			searchValue(node.left,key);
		}else {
			searchValue(node.right,key);	
		}
	}
	
	
	//find maximum and minimum
	void findMin(Node node) {
		if(node.left==null) {
			System.out.println("min : "+node.data);
			return;
		}
		
		findMin(node.left);
	}
	
	void findMax(Node node) {
		if(node.right==null) {
			System.out.println("max : "+node.data);
			return;
		}
		
		findMax(node.right);
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
