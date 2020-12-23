package question12;
import java.util.*;

public class UsingQueue {
	public static void main(String args[]) {
		Tree tree=new Tree(4);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(-5);
		
		tree.root.left.left=new Node(-1);
		tree.root.left.right=new Node(3);
		tree.root.right.left=new Node(-2);
		tree.root.right.right=new Node(6);
		
		System.out.println("Max sum can be : "+ tree.findMaxSum(tree));
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
	Node root;
	
	Tree(int data){
		root = new Node(data);
	}
	
	int findMaxSum(Tree tree) {
		
		int sum=0;
		int finalSum=Integer.MIN_VALUE;
		
		if(root.left==null && root.right==null) {
			finalSum=root.data;
		}else {
			Queue<Node> queue=new LinkedList<Node>();
			queue.add(root);
			queue.add(new Node(Integer.MAX_VALUE));
			
			while(!queue.isEmpty()) {//O(n) time and space
				Node node=queue.remove();
				
				if(node.data==Integer.MAX_VALUE) {
					if(sum>finalSum) {
						finalSum=sum;
					}
					sum=0;
					if(!queue.isEmpty()) {//bcz if is empty then by just adding everytime, it will turn to infinte loop
						queue.add(new Node(Integer.MAX_VALUE));
					}
				}else {
					sum+=node.data;
				}
				
				if(node.left!=null) {
					queue.add(node.left);
				}
				
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
			
		}
		return finalSum;
	}
}