package findAllSubTrees;
import java.util.*;

/*
 O(n) time				O(n) space
 basically hum jab bhi aise subtree nikalenge to deep jayenge pehle fir niche se backtrack
 krenge by generating string and concatenating them with node.data adding them to map
 so we can make use of inOrder to go deep first then adding node.data to it
 
 here we receive left subtree and right subtree every time and then concatenate,
 bcz for leaf node we already received $ as left and right,
 so they are added to map
 
 for above to it subtree can be form using those leaf nodes,so we return left and right subtree formed string
 */
public class InorderTraversal {
	static HashMap<String,Integer> map=new HashMap<String,Integer>();
	
	public static void main(String args[]) {
		
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
}
