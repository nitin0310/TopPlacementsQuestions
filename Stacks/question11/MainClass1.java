package question11;
import java.util.*;

public class MainClass1 {

	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push(2);
		stack.push(3);
		System.out.print(stack.pop()+" ");
		stack.push(4);
		System.out.print(stack.pop()+" ");
	}

}

class Stack{
	
	Queue<Integer> queue1=new LinkedList<Integer>();
	Queue<Integer> queue2=new LinkedList<Integer>();
	
	void push(int data) {
		queue1.add(data);
	}
	
	int pop() {
		if(queue1.size()==0) {
			return -1;
		}else {
			for(int i=0;i<queue1.size()-1;i++) {
				queue2.add(queue1.remove());
			}
			int poppedElement=queue1.remove();
			if(queue1.size()>1) {
				for(int i=0;i<queue2.size();i++) {
					queue1.add(queue2.remove());
				}
			}
			return poppedElement;
		}
	}
	
}
