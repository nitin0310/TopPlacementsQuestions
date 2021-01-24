package question12;

public class UsingRecursion {
	//O(n) time								O(n) space--to store result so that we don't need to recurse again and again
	//working as a kind of dp
	public static void main(String args[]) {
		Tree tree=new Tree(10);
		
		tree.root.left=new Node(20);
		tree.root.right=new Node(30);
		
		tree.root.left.left=new Node(10);
		tree.root.left.right=new Node(10);
		
		int sum[]=new int[500];//length nikal k use bhi pass kr skte hai
		System.out.println(validateSumTree(tree.root,0,sum));
	}
	
	static boolean validateSumTree(Node node,int index,int sum[]) {
		//actually hume pta hona chaiye ki present node ka left child and right child ka index so that hum
		//aage pass kr denge or fir at that node time, wo apni sum[] me daal dega,
		//fir hum unhe use kr k validate kr skte hai
		
		boolean flag=false;
		
		if(node==null) {
			return true;
		}
		
		if(node.left==null && node.right==null) {
			sum[index]=node.data;
			return true;
		}
		
		//important cond. to take care of---left child and right child index: (2*index)+1,,,,,,(2*index)+2
		if(validateSumTree(node.left,(index*2)+1,sum) && validateSumTree(node.right,(index*2)+2,sum)) {
			if((sum[(index*2)+1] + sum[(index*2)+2])==node.data) {
				sum[index]=sum[(index*2)+1] + sum[(index*2)+2]+node.data;
				flag=true;
			}
		}
		
		return flag;
	}
	
	
}
