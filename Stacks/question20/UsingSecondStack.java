package question20;
import java.util.*;

public class UsingSecondStack {
	//O(n) --time 			(n) --space
	public static void main(String args[]) {
		Stack2 stack=new Stack2();
		stack.printStack(stack);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack(stack);
		System.out.println();
		stack.insertAtBottom(stack, 6);
		stack.printStack(stack);
	}
}

class Stack2 extends Stack<Integer>{
	
	void insertAtBottom(Stack2 instance, int data) {
		Stack<Integer> tempStack=new Stack<Integer>();
		while(!instance.isEmpty()) {
			tempStack.push(instance.pop());
		}
		tempStack.push(data);
		
		while(!tempStack.isEmpty()) {
			instance.push(tempStack.pop());
		}
	}
	
	void printStack(Stack2 instance) {
		if(instance.isEmpty()) {
			System.out.println("Nothing inside stack/underflow");
		}else {
			Iterator itr=instance.iterator();
			
			while(itr.hasNext()) {
				System.out.print(itr.next()+" ");
			}
		}
	}
	
}
