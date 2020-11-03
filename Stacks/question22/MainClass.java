package question22;
import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		Stack2 stack=new Stack2();
		stack.push(14);
		stack.push(19);
		stack.push(7);
		stack.push(10);
		stack.printStack(stack);
		stack.sortStack(stack);
		stack.printStack(stack);
	}

}

class Stack2 extends Stack<Integer>{
	
	void sortStack(Stack2 instance) {
		if(instance.isEmpty()) {
			return;
		}
		
		int holdValue=instance.pop();
		sortStack(instance);
		
		insertCorrectly(instance,holdValue);
	}
	
	void insertCorrectly(Stack2 instance, int holdValue) {
		if(instance.isEmpty()) {
			instance.push(holdValue);
		}else {
			if(holdValue<instance.peek()) {
				instance.push(holdValue);
			}else{
				int hold=instance.pop();
				insertCorrectly(instance,holdValue);
				instance.push(hold);
			}
		}
	}
	
	void printStack(Stack2 instance) {
		if(instance.isEmpty()) {
			System.out.println("Nothing to print!");
		}else {
			Iterator itr=instance.iterator();
			while(itr.hasNext()) {
				System.out.print(itr.next()+" ");
			}
			System.out.println();
		}
	}
	
}
