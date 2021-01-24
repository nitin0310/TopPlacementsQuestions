package question1;

public class Tree {
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