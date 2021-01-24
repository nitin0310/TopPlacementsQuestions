package question1;

import java.util.HashMap;
import java.util.Map;

//wea ren't using treeMap bcz we don't require any ascending printing or ordered printing,
//we are just adding in map with out recursion
public class LeftViewUsingHashMap {
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.right=new Node(4);
		tree.root.left.right.right=new Node(5);
		tree.root.left.right.right.right=new Node(6);
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		printLeftView(tree.root,0,map);
		printMap(map);
	}
	
	static void printLeftView(Node node,int level,HashMap<Integer,Integer> map) {
		if(node==null) {
			return;
		}
		
		if(!map.containsKey(level)) {
			map.put(level, node.data);
		}
		//here we are adding +1 to both left and right,bcz we are going as down,
		//so we need to take care about same depth as horizontally and need to pick
		//the first coming in that particular depth
		printLeftView(node.left,level+1,map);
		printLeftView(node.right,level+1,map);
	}
	
	static void printMap(HashMap<Integer,Integer> map) {
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}
}
