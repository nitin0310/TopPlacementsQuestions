package question15;
import java.util.*;

public class MainClass {
	//O(1) --time			O(1) --space
	public static void main(String[] args) {
		Stack2 instance=new Stack2();
		instance.push(3);
		instance.push(5);
		instance.push(2);
		instance.push(1);
		instance.getMin();
		
		instance.pop();
		instance.getMin();
		
		instance.pop();
		instance.getMin();

	}

}

class Stack2 extends Stack<Integer>{
	
	Stack<Integer> stack=new Stack<Integer>();
	
	int minElement;
	
	/**
	 push:
	 main funda is -ki normal chal ra hai insert krte rho min hai wo thik hai but
	 agar min se lesser mil jaye to obvious wo min to ho jayega but actual stack me
	 formaula se aisi value generate krenge ki data se kam ho jaye fir use stack me
	 insert kr denge taaki wo alag hi indicate kr de
	 
	 pop:
	 main funda ye tha -ki ek min value hai hi push se store minElement me
	 agar wo top se match kr ri hai to normal hi chal ra hai
	 but agar match ni kr ri or kam hai min se then obvious wo indicate kr ri hai
	 ki ye kisi min k baad min hua tha -then hum formaula se wo prev min nikal lenge
	 and update kr denge 
	 */
	
	public void push(int data) {
		if(stack.isEmpty()) {
			stack.push(data);
			minElement=data;
		}else {
			if(data>=minElement) {
				stack.push(data);
			}else {
				stack.push(2*data-minElement);
				minElement=data;
			}
		}
	}
	
	public Integer pop() {
		if(stack.isEmpty()) {
			return -1;
		}else {
			int data=stack.pop();
			if(minElement>data) {
				minElement=2*minElement-data;
			}
			return data;
		}
	}
	
	void getMin() {
		System.out.println(minElement);
	}
}
