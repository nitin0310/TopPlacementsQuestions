package question19;

import java.util.HashMap;

public class MemoizedUsingMap {
	//O(n) but we can memoize it using hashMap			O(n) space
	public static void main(String args[]) {
		Tree tree=new Tree(10);
		
		tree.root.left=new Node(1);
		tree.root.left.left=new Node(2);
		tree.root.left.right=new Node(3);
		tree.root.left.left.left=new Node(1);
		tree.root.left.right.left=new Node(4);
		tree.root.left.right.right=new Node(5);
		
		HashMap<Node,Integer> map=new HashMap<Node,Integer>();
		System.out.println(findMaxSum(tree.root,map));
	}
	
	static int findMaxSum(Node node,HashMap<Node,Integer> map) {
		//when there's no node present then the sum we can get from that is 0
		if(node==null) {
			return 0;
		}
		
		//basically if have already counted counted max sum for that node,then simply return it.no need to make calls further
		if(map.containsKey(node)) {
			return map.get(node);
		}
		//if no child return that data
		if(node.left==null && node.right==null) {
			return node.data;
		}
		
		//include that node,now we can only call for its grandChildren and then add it
		int included=node.data+findSumOfGrandChildren(node,map);
		
		//if not including then we can make call for its children and then choice for further to include or not
		int notIncluded=findMaxSum(node.left,map)+findMaxSum(node.right,map);
		
		//if have just calculated then add it,so that we don't need to make more calls in future
		map.put(node, Math.max(included, notIncluded));
		//finally we get 2 answers where we once included once not included,return max of them
		return map.get(node);
	}
	
	static int findSumOfGrandChildren(Node node,HashMap<Node,Integer> map) {
		
		int sum=0;
		
		//simply making calls for max sum possible from grand children
		if(node.left!=null) {
			sum+=findMaxSum(node.left.left,map) + findMaxSum(node.left.right,map);
		}
		
		if(node.right!=null) {
			sum+=findMaxSum(node.right.left,map) + findMaxSum(node.right.right,map);
		}
		
		return sum;
	}
}

