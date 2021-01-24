package question7;

public class MainClass {
	static int levelOr=0;
	
	public static void main(String args[]) {
		Tree tree=new Tree();
		
	}
	
	static Node buildTree(int[] inOrder,int[] levelOrder,int start,int end) {
		if(start>end) {
			return null;
		}
		
		Node node=new Node(levelOrder[levelOr++]);
		int index=searchIndex(inOrder,node.data)
		
		
		
		return node;
	}
	
	static int searchIndex(int[] inOrder,int data) {
		for(int i=0;i<inOrder.length;i++) {
			if(inOrder[i]==data) {
				return i;
			}
		}
		
		return -1;
	}
}

class Tree{
	Node root;
}

class Node{
	Node left;
	Node right;
	int data;
	
	Node(int data){
		this.data=data;
	}
}