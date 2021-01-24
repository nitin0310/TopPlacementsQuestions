package question1;

import java.util.Map;
import java.util.TreeMap;

public class BottomViewUsingVerticalOrder {
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.right=new Node(4);
		tree.root.left.right.right=new Node(5);
		tree.root.left.right.right.right=new Node(6);
		
		tree.root.left.right.left=new Node(7);
		
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		printBottomView(tree.root,0,map);
		printMap(map);
	}
	
	static void printBottomView(Node node,int level,TreeMap<Integer,Integer> map) {
		if(node==null) {
			return;
		}
		
		//left--right--root
		//bcz it help to consider below values first,
		//or we can say the bottom values,that we usually require,after getting them no need to replace them with upper values
		printBottomView(node.left,level-1,map);
		printBottomView(node.right,level+1,map);
		
		//using a kind of vertical traversal --that can be helped by treeMap
		if(!map.containsKey(level)) {
			map.put(level, node.data);
		}
		
	}
	
	static void printMap(TreeMap<Integer,Integer> map) {
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}
}
