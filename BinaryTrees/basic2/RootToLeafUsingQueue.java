package basic2;

public class RootToLeafUsingQueue {
//O(n^2) time			O(h) space
	public static void main(String args[]) {
		//it is a binary tree not bst
		Tree2 tree=new Tree2(10);
		
		tree.root.left=new Node2(8);
		tree.root.right=new Node2(2);
		
		tree.root.left.left=new Node2(3);
		tree.root.left.right=new Node2(5);
		tree.root.right.left=new Node2(2);
		int paths[]=new int[1000];
		int index=0;
		
		printPaths(tree.root,paths,index);
	}
	
	static void printPaths(Node2 node,int[] paths,int index) {
		if(node==null) {
			return;
		}
		
		if(node.left==null && node.right==null) {
			paths[index]=node.data;
			index++;
			printArray(paths,index);
			return;
		}
		
		paths[index]=node.data;
		index++;
		
		printPaths(node.left,paths,index);
		printPaths(node.right,paths,index);
	}
	
	static void printArray(int[] array,int index) {
		
		for(int i=0;i<index;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}

class Tree2{
	Node2 root;
	Tree2(int data){
		root=new Node2(data);
	}
}

class Node2{
	Node2 left;
	Node2 right;
	int data;
	
	Node2(int data){
		this.data=data;
	}
}