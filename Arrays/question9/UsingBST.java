package question9;

import java.io.BufferedReader;
import java.io.*;

public class UsingBST {			//O(logn)
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		BST bst=new BST();
		
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(br.readLine());
			bst.insert(value);
		}
		
		System.out.println("range of array is : "+(bst.max()-bst.min()));
	}
}

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
	}
}

class BST{
	Node root=null;
	
	void insert(int data) {
		Node newnode=new Node(data);
		if(root==null) {
			root=newnode;
		}else {
			Node temp=root;
			Node prev=temp;
			while(temp!=null) {
				prev=temp;
				if(data<temp.data) {
					temp=temp.left;
				}else {
					temp=temp.right;
				}
			}
			
			if(data<prev.data)
				prev.left=newnode;
			else
				prev.right=newnode;
		}
	}
	
	int max() {
		
		if(root==null) {
			return Integer.MIN_VALUE;
		}else {
			Node temp=root;
			while(temp.right!=null) {
				temp=temp.right;
			}
			return temp.data;
		}
	}
	
	int min() {
		
		if(root==null) {
			return Integer.MAX_VALUE;
		}else {
			Node temp=root;
			while(temp.left!=null) {
				temp=temp.left;
			}
			return temp.data;
		}
	}
}

