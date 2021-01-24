package question24;
import java.util.*;

public class UsingHashMap {
	//variation from finding all subtree and similar to question 14,
	//O(n) time									O(n) space
	
	static HashMap<String,Integer> map=new HashMap<String,Integer>();
	
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(3);
		tree.root.right=new Node(6);
		
		tree.root.left.left=new Node(2);
		tree.root.left.right=new Node(4);
		
		tree.root.right.left=new Node(3);
		tree.root.right.left.left=new Node(2);
		tree.root.right.left.right=new Node(4);
		
		findAllSubtrees(tree.root);
		findAllDuplicates();
	}
	
	static String findAllSubtrees(Node node) {
		if(node==null) {
			return "$";
		}
		
		String string="";
		String left=findAllSubtrees(node.left);//basically backtrack krta krta ye sbhi subtrees ko add krta rhega map me left side se
		string=string.concat(left+Integer.toString(node.data));//ye current node ko bhi add krne k liye,jis bhi sub tree ka ye part hoga
		String right=findAllSubtrees(node.right);//basically backtrack krta krta ye sbhi subtrees ko add krta rhega map me right side se
		
		string=string.concat(right);
		
		//adding to map
		if(map.containsKey(string)) {
			map.put(string, (map.get(string))+1);
		}else {
			map.put(string, 1);
		}
		
		return string;
	}
	
	static void findAllDuplicates() {
		for(Map.Entry<String, Integer> e:map.entrySet()) {
			if(e.getValue()>1) {
				System.out.println((e.getKey()));
			}
		}
	}
}
