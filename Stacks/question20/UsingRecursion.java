package question20;
import java.util.*;

public class UsingRecursion {
	//recursion will help to save extra space by just holding values
	//O(n) --time				O(1) --space
	public static void main(String[] args) {
		Stack3 stack=new Stack3();
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

class Stack3 extends Stack<Integer>{
	
	void insertAtBottom(Stack3 instance, int data) {
		if(instance.isEmpty()) {
			instance.push(data);
			return;
		}
		
		int holdedValue=instance.pop();
		insertAtBottom(instance,data);
		instance.push(holdedValue);
		
	}
	
	void printStack(Stack3 instance) {
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
