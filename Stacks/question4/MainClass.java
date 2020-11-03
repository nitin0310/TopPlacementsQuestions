package question4;
import java.util.*;

public class MainClass {
	//time --O(1)					space --O(n)
	public static void main(String[] args) {
		SpecialStack instance=new SpecialStack();
		instance.push(18);
		instance.push(19);
		instance.push(29);
		instance.push(15);
		instance.push(16);
		
		instance.min();
		instance.popIt();
		instance.popIt();
		instance.min();

	}
}

class SpecialStack extends Stack<Integer>{
	Stack<Integer> actual=new Stack<Integer>();
	Stack<Integer> auxiliary=new Stack<Integer>();
	
	//having another stack as well that actually won't update
	//whole stack every time,but update top every time.every time another stack
	//surely add element,but if smaller then that else again add the top element of another
	//stack.i.e we store same no. of elements in another stack as well, but may
	//store same elements multiple times as well 
	
	void push(int data) {
		if(auxiliary.isEmpty()) {
			actual.push(data);
			auxiliary.push(data);
		}else {
			actual.push(data);
			if(data<auxiliary.peek()) {
				auxiliary.push(data);
			}else{
				auxiliary.push(auxiliary.peek());
			}
		}
	}
	
	int popIt() {
		if(actual.isEmpty()) {
			return -1;
		}else {
			auxiliary.pop();
			return actual.pop();
		}
	}
	
	void min() {
		if(actual.isEmpty()) {
			System.out.println("null is minimum");
		}else {
			System.out.println(auxiliary.pop());
		}
	}

}