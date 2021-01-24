package question19;

public class UsingRecursion {
	//O(2^n) but we can memoize it using hashMap			O(1) space
	public static void main(String args[]) {
		Tree tree=new Tree(10);
		
		tree.root.left=new Node(1);
		tree.root.left.left=new Node(2);
		tree.root.left.right=new Node(3);
		tree.root.left.left.left=new Node(1);
		tree.root.left.right.left=new Node(4);
		tree.root.left.right.right=new Node(5);
		
		System.out.println(findMaxSum(tree.root));
	}
	
	static int findMaxSum(Node node) {
		//when there's no node present then the sum we can get from that is 0
		if(node==null) {
			return 0;
		}
		
		//if no child return that data
		if(node.left==null && node.right==null) {
			return node.data;
		}
		
		//include that node,now we can only call for its grandChildren and then add it
		int included=node.data+findSumOfGrandChildren(node);
		
		//if not including then we can make call for its children and then choice for further to include or not
		int notIncluded=findMaxSum(node.left)+findMaxSum(node.right);
		
		
		
		//finally we get 2 answers where we once included once not included,return max of them
		return Math.max(included, notIncluded);
	}
	
	static int findSumOfGrandChildren(Node node) {
		
		int sum=0;
		
		//simply making calls for max sum possible from grand children
		if(node.left!=null) {
			sum+=findMaxSum(node.left.left) + findMaxSum(node.left.right);
		}
		
		if(node.right!=null) {
			sum+=findMaxSum(node.right.left) + findMaxSum(node.right.right);
		}
		
		return sum;
	}
}
