package question1;
import java.util.*;

public class TopViewUsingVerticalOrder {
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		
		tree.root.left.right=new Node(4);
		tree.root.left.right.right=new Node(5);
		tree.root.left.right.right.right=new Node(6);
		
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		printTopView(tree.root,0,map);
		printMap(map);
	}
	
	static void printTopView(Node node,int level,TreeMap<Integer,Integer> map) {
		if(node==null) {
			return;
		}
		
		//left--right--root
		//bcz it help to consider below values as well and when parents node come after them,
		//then it update the value to parent value bcz we need to print a kind of parents i.e top/upper values in tree
		printTopView(node.left,level-1,map);
		printTopView(node.right,level+1,map);
		
		//using a kind of vertical traversal --that can be helped by treeMap
		map.put(level, node.data);
		
	}
	
	static void printMap(TreeMap<Integer,Integer> map) {
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
	}
}
