package question2;
import java.util.*;


public class UsingArrayList {
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.right=new Node(5);
		tree.root.left.right.left=new Node(6);
		tree.root.left.right.right=new Node(7);
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		findNthNodeInorder(tree.root,3,list);
	}
	
	static void findNthNodeInorder(Node node,int n,ArrayList<Integer> list) {
		if(node==null) {
			return;
		}
		
		findNthNodeInorder(node.left,n,list);
		if(list.size()<n) {
			list.add(node.data);
		}else if(list.size()==n) {
			System.out.println("Inorder "+n+"th node : "+list.get(n-1));
			list.add(-1);//adding this value to stop twice printing,so we can add any value not only -1,
			//here we are returning from a tree after adding then it's printing again.So that's why
			return;
		}else {
			return;
		}
		findNthNodeInorder(node.right,n,list);
	}
}

class Tree {
	Node root;
	Tree(int data){
		root = new Node(data);
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