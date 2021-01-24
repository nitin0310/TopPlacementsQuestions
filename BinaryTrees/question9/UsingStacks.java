package question9;
import java.util.*;

/*
 
 first we will push elements to the stack as in order--right root left,
 bcz this is the same order of out Linked List as well.
 
 after pushing them we need to link them one by one,bcz as in stack they are linked random as in tree,
 so we make use of recursion to link them continuously,
 now to link prev node as well, we send current node reference to next recursive call,after liking we return current node
 we passed null bcz at first in left reference and last in right reference there must be null
 so at last they all are linked and we get head,
 then print the linked list
 */
public class UsingStacks {
	//O(n) time						O(n) space
	public static void main(String args[]) {
		Tree tree=new Tree(10);
		
		tree.root.left=new Node(20);
		tree.root.right=new Node(30);
		
		tree.root.left.left=new Node(40);
		tree.root.left.right=new Node(60);
		
		Stack<Node> stack=new Stack<Node>();
		stack=convertToDLL(tree.root,stack);
		Node head=doLinking(stack,null);
		printLinkedList(head);
	}
	
	static Stack<Node> convertToDLL(Node node,Stack<Node> stack) {
		if(node==null) {
			return stack;
		}
		
		convertToDLL(node.right,stack);
		stack.push(node);
		convertToDLL(node.left,stack);
		
		return stack;
	}
	
	static Node  doLinking(Stack<Node> stack,Node prev) {
		if(stack.isEmpty()) {
			return null;
		}
		
		Node top=stack.pop();
		Node next=doLinking(stack,top);
		top.right=next;
		top.left=prev;
		
		return top;
	}
	
	static void printLinkedList(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.right;
		}
		System.out.println();
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