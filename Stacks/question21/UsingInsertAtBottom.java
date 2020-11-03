package question21;
import java.util.*;

public class UsingInsertAtBottom {
	//O(n^2) --time					O(1) --space
	public static void main(String[] args) {
		Stack2 stack=new Stack2();
		stack.printStack(stack);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack(stack);
		System.out.println();
		stack.reverseStack(stack);
		stack.printStack(stack);
	}

}

class Stack2 extends Stack<Integer>{
	
	void reverseStack(Stack2 instance) {
		if(instance.isEmpty()) {
			return;
		}else {
			int holdedValue=instance.pop();
			reverseStack(instance);
			insertAtBottom(instance,holdedValue);
		}
	}
	
	void insertAtBottom(Stack2 instance, int data) {
		if(instance.isEmpty()) {
			instance.push(data);
			return;
		}
		
		int holdedValue=instance.pop();
		insertAtBottom(instance,data);
		instance.push(holdedValue);
		
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
