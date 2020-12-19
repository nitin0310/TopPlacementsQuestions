package question15;
import java.util.*;

public class UsingRecursion {
	public static void main(String args[]) {
		Tree tree1=new Tree(1);
		tree1.root.left=new Node(3);
		tree1.root.right=new Node(2);
		tree1.root.right.left=new Node(5);
		tree1.root.right.right=new Node(4);
		
		Tree tree2=new Tree(1);
		tree2.root.left=new Node(2);
		tree2.root.right=new Node(3);
		tree2.root.left.left=new Node(4);
		tree2.root.left.right=new Node(5);
		
		tree1.traverse(tree1.root);
		System.out.println();
		tree2.traverse(tree2.root);
		System.out.println();
		
		Collections.sort(tree1.list);
		Collections.sort(tree2.list);
		
		if(tree1.list.size()!=tree2.list.size()) {
			System.out.println("Not an anagram");
		}else {
			Iterator itr=tree1.list.iterator();
			Iterator itr2=tree2.list.iterator();
			
			boolean flag=true;
			while(itr.hasNext()) {
				if(itr.next()!=itr2.next()) {
					flag=false;
				}
			}
			
			System.out.println(flag?"Anagram":"Not an anagram");
		}
		
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
	LinkedList<Integer> list=new LinkedList<Integer>();
	
	Node root;
	Tree(int data){
		root = new Node(data);
	}
	
	void traverse(Node node) {
		if(node==null) {
			return;
		}
		
		System.out.print(node.data+" ");
		list.add(node.data);
		if(node.left!=null) {
			traverse(node.left);
		}
		
		if(node.right!=null) {
			traverse(node.right);
		}
	}
}