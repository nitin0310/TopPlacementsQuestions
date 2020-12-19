package question1;
import java.util.*;

public class QueueUsing2Stacks {
	//push() -O(1) 							pop() -O(n)
	public static void main(String args[]) {
		Queue instance = new Queue();
		instance.push(10);
		instance.push(20);
		instance.push(30);
		System.out.println(instance.pop());
		instance.push(40);
		System.out.println(instance.pop());
	}
}

class Queue{
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	
	void push(int data) {
		stack1.push(data);
	}
	
	int pop() {
		if(stack1.isEmpty() && stack2.isEmpty()) {
			return -1;
		}
		System.out.println("Size : "+stack1.size());
		for(int i=1;i<=stack1.size();i++) {
			stack2.push(stack1.pop());
		}
		
		if(stack1.isEmpty()) {
			//System.out.println("called");
			return stack2.pop();
		}
		
//		Iterator itr=stack1.iterator();
//		
//		while(itr.hasNext()) {
//			System.out.print(itr.next()+" ");
//		}
//		System.out.println();
		int data = stack1.pop();
		
		for(int i=0;i<stack2.size();i++) {
			stack1.push(stack2.pop());
		}
		
		return data;
	}
}