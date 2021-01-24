package question21;
import java.util.*;

public class UsingPreOrderAndArrayList {
	//O(n^2) time						O(n) space
	static ArrayList<Integer> paths=new ArrayList<Integer>();
	
	public static void main(String args[]) {
		Tree tree=new Tree(1);
		
		tree.root.left=new Node(3);
		tree.root.right=new Node(-2);
		
		tree.root.left.right=new Node(4);
		
		int k=4;
		findKSumPaths(tree.root,k);
	}
	
	
	//simply doing a preOrder traversal, and adding each node we are visiting as in the path
	//but at the same time when both call done, then we check from last i.e the node added
	//to back side and updating sum and checking it to sum,
	//if true,then pass its start index and print till last value
	static void findKSumPaths(Node node,int k) {
		if(node==null) {
			return;
		}
		
		paths.add(node.data);
		
		findKSumPaths(node.left,k);
		findKSumPaths(node.right,k);
		
		//checking path we get
		int sum=0;
		for(int i=paths.size()-1;i>=0;i--) {
			sum+=paths.get(i);
			
			if(sum==k) {
				printPath(i);
			}
		}
		
		//must condition bcz we have checked this,now remove this and backtrack
		paths.remove(paths.size()-1);
	}
	
	static void printPath(int start) {
		for(int i=start;i<paths.size();i++) {
			System.out.print(paths.get(i)+" ");
		}
		System.out.println();
	}
}
