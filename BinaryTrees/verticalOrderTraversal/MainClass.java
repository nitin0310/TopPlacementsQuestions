package verticalOrderTraversal;

import java.util.*;

/*
 using treeMap to keep order of levels,that helps to print vertically
 using arrayList to keep adding elements of same level
*/

public class MainClass {
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		tree.root.right.left=new Node(6);
		tree.root.right.right=new Node(7);
		
		tree.root.right.right.left=new Node(8);
		tree.root.right.right.right=new Node(9);
		
		TreeMap<Integer,ArrayList<Node>> map=new TreeMap<Integer,ArrayList<Node>>();
		verticalTraversal(tree.root,0,map);
		printTree(map);
	}
	
	static void verticalTraversal(Node node,int level,TreeMap<Integer,ArrayList<Node>> map) {
		if(node==null) {
			return;
		}
		
		ArrayList<Node> list=new ArrayList<Node>();
		
		if(map.containsKey(level)) {
			list=map.get(level);
			list.add(node);
			map.put(level, list);
		}else {
			list.add(node);
			map.put(level, list);
		}
		
		verticalTraversal(node.left,level-1,map);
		verticalTraversal(node.right,level+1,map);
	}
	
	static void printTree(TreeMap<Integer,ArrayList<Node>> map) {
		for(Map.Entry<Integer, ArrayList<Node>> entry:map.entrySet()) {
			for(int i=0;i<entry.getValue().size();i++) {
				System.out.print(entry.getValue().get(i).data+" ");
			}
			System.out.println();
		}
	}
}

class Tree{
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