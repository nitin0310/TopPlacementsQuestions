package question14;
import java.util.*;

public class UsingHashMap {
	public static void main(String args[]) {
		Tree tree=new Tree(3);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(6);
		
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		
		tree.root.right.right=new Node(2);
		tree.root.right.right.right=new Node(4);
		tree.root.right.right.right.right=new Node(5);
		
//		tree.root.right.right=new Node(2);
//		tree.root.right.right.left=new Node(4);
//		tree.root.right.right.right=new Node(5);
		
		System.out.println(checkDuplicateOrNot(tree.root));
	}
	
	static boolean checkDuplicateOrNot(Node node) {
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		addSubTreesToMap(node,map);
		
		for(Map.Entry<String, Integer> e:map.entrySet()) {
			if(e.getValue()>1) {
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 main funda--
	 we just need to take care about that no tree is added with size less than 2,
	 so we are checking left and right null or not
	 
	 if any skewed tree or root having on child then in that missing place we have to add
	 something else return true for not even duplicacy(edge cases)
	 
	 so we are returning $
	 */
	static String addSubTreesToMap(Node node,HashMap<String,Integer> map) {
		
		if(node==null) {
			return "$";
		}
		
		String str="";
		//if have no child then no need to add to map, bcz must have size > 1,that's why
		if(node.left==null && node.right==null) {
			str=str.concat(Integer.toString(node.data));
			return str;
		}
		
		//if having both children, then add to map after concatenation
		str=str.concat(Integer.toString(node.data));
		String left=addSubTreesToMap(node.left,map);
		String right=addSubTreesToMap(node.right,map);
		
		str=str.concat(left);
		str=str.concat(right);
		
		//increment frequency is already present, bcz that is duplicate
		if(map.containsKey(str)) {
			map.put(str, map.get(str)+1);
		}else {
			map.put(str, 1);
		}
		
		return str;
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