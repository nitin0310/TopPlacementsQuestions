package question1;

import java.util.HashMap;
import java.util.Map;

public class RightViewUsingHashMap {
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.right=new Node(4);
		tree.root.left.right.right=new Node(5);
		tree.root.left.right.right.right=new Node(6);
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		printRightView(tree.root,0,map);
		printMap(map);
	}
	
	static void printRightView(Node node,int level,HashMap<Integer,Integer> map) {
		if(node==null) {
			return;
		}
		
		map.put(level, node.data);
		//here we are adding +1 to both left and right,bcz we are going as down,
		//so we need to take care about same depth as horizontally and we are updating
		//as we are getting elements on that depth further horizontally
		printRightView(node.left,level+1,map);
		printRightView(node.right,level+1,map);
	}
	
	static void printMap(HashMap<Integer,Integer> map) {
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}
}
