package question15;
import java.util.*;

public class UsingStackAndQueue {
	//O(n) time							O(n) space
	static boolean flag=true;
	
	public static void main(String args[]) {
		int parent1[]= {1,1,1,3,3};
		int child1[]= {2,3,4,5,6};
		
		int parent2[]= {1,1,1,3,3};
		int child2[]= {4,3,2,5,6};
		
		if(parent1.length!=parent2.length) {//if both tree don't even have same no. of nodes,then they can't be mirrored
			flag=false;
		}else {
			checkMirrorOrNot(parent1,child1,parent2,child2,0,0);
		}
		System.out.println(flag);
	}
	
	//to keep track of parents, we used node1 and node2 that will help us to check whether both parents have child mirrored
	static void checkMirrorOrNot(int parent1[],int child1[],int parent2[],int child2[],int index1,int index2) {
		
		//if index exceeds then can't check further, else index bound error
		if(index1>=parent1.length || index2>=parent2.length) {
			return;
		}
		int node1=parent1[index1];
		
		int node2=parent2[index1];
		
		Queue<Integer> queue=new LinkedList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		
		//inserting child nodes of particular parent of tree1
		while(index1<parent1.length && parent1[index1]==node1) {
			queue.add(child1[index1]);
			index1++;
		}
		
		//inserting child nodes of particular parent of tree2
		while(index2<parent2.length && parent2[index2]==node2) {
			stack.push(child2[index2]);
			index2++;
		}
		
		//recursive call so that it help us to check for next parent
		validateBothTreeNodes(queue,stack);
		
		if(flag) {
			checkMirrorOrNot(parent1,child1,parent2,child2,index1,index2);
		}else {
			return;
		}
	}
	
	static void validateBothTreeNodes(Queue<Integer> queue,Stack<Integer> stack) {
		while(!queue.isEmpty() && !stack.isEmpty()) {
			int t1Node=queue.remove();
			int t2Node=stack.pop();
			
			//checking top elements of both ds
			if(t1Node!=t2Node) {
				flag=false;
			}
		}
	}
}
