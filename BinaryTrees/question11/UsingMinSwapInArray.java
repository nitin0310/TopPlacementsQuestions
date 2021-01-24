package question11;

import java.util.*;

public class UsingMinSwapInArray {
	//O(n logn) time						O(n) space
	static int index=0;
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		ArrayList<Integer> array=new ArrayList<Integer>();
		inOrder(tree.root,array);
		
		System.out.println(findMinSwapToSort(array));
	}
	
	//first do inorder traversal of given tree,so that we get that unsorted array,
	//and we know inorder traversal of a bst must be a sorted array,
	//so we just need to find minimum swap requires to sort an array, and we know this.
	
	static void inOrder(Node node,ArrayList<Integer> array) {
		if(node==null) {
			return;
		}
		
		inOrder(node.left,array);
		array.add(index++, node.data);//don't worry, this is just for incrementing index at next call,nothing at all
		inOrder(node.right,array);
	}
	
	//---------------------------------------------------------------------
	static int findMinSwapToSort(ArrayList<Integer> array) {
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		int swapCount=0;
		
		//adding each value with its current index of unsorted ordered array
		for(int i=0;i<array.size();i++) {
			map.put(array.get(i), i);
		}
		
		int index=0;
		while(index<array.size()) {
			//it removes first entry every time from tree,i.e the smallest key
			Map.Entry<Integer, Integer> entry=map.pollFirstEntry();
			
			//here each key holds its unsorted index, now it meets that unsorted that means we don't need to swap
			if(entry.getValue()==index) {
				index++;
			}else {
				//f it doesn't meets then we swap the values but as in map value
				int valueInArray=array.get(index);
				map.put(valueInArray, entry.getValue());
				map.put(entry.getKey(),index);
				
				swapCount++;
			}
		}
		
		return swapCount;
		
	}
	//---------------------------------------------------------------------
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