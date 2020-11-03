package question8;
import java.util.*;

public class Method1 {

	//Queue implementation using 2 stacks
	public static void main(String[] args) {
		Queue queue=new Queue();
		queue.add(2);
		queue.add(3);
		queue.remove();
		queue.add(4);
		queue.remove();
	}

}

class Queue{
	Stack<Integer> stack1=new Stack<Integer>();
	Stack<Integer> stack2=new Stack<Integer>();
	
	//O(1) --time
	void add(int data) {
		stack1.push(data);
	}
	
	//O(n) --time
	void remove() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		System.out.print(stack2.pop()+" ");
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
}
