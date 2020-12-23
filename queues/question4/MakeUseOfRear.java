package question4;
import java.util.*;

public class MakeUseOfRear {
	public static void main(String args[]) {
		Queue instance = new Queue();
		Queue secondQueue = new Queue();
		
		instance.display();
		instance.add(3);
		instance.add(17);
		instance.add(6);
		instance.add(19);
		instance.add(9);
		
		instance.display();
		instance.sortTheQueue(secondQueue);
		secondQueue.display();
	}
}

class Queue{
	int front=-1;
	int rear=-1;
	
	int queue[]=new int[20];
	
	boolean isFull() {
		if(rear==queue.length-1) {
			return true;
		}
		return false;
	}
	
	boolean isEmpty() {
		if((front==-1 && rear==-1) || (front>rear)) {
			return true;
		}
		return false;
	}
	
	void add(int data) {
		if(isFull()) {
			System.out.println("Can't add! Queue is full.");
		}else if(isEmpty()) {
			front=rear=0;
			queue[front]=data;
		}else {
			rear++;
			queue[rear]=data;
		}
	}
	
	int remove() {
		if(isEmpty()) {
			return -1;
		}else {
			int data = queue[front];
			if(front==rear) {//last element exists
				front=rear=-1;
			}else {
				front++;
			}
			return data;
		}
	}
	
	void display() {
		if(isEmpty()) {
			System.out.println("Nothing to show! Queue is empty.");
		}else {
			int index=front;
			while(index<=rear) {
				System.out.print(queue[index]+" ");
				index++;
			}
			System.out.println();
		}
	}
	
	void sortTheQueue(Queue secondQueue) {
		//do take care of index
		Stack<Integer> stack = new Stack<Integer>();
		
		
		for(int i=0;i<queue.length;i++) {
			if(stack.isEmpty()) {
				stack.push(queue[i]);
			}else {
				while((!stack.isEmpty()) && stack.peek()<queue[i]) {
					secondQueue.add(stack.pop());
				}
				stack.push(queue[i]);
				System.out.println(secondQueue.front+" ----- ");
				System.out.println(secondQueue.rear+" -- -- ");
				for(int j=secondQueue.rear;j>=0;j--) {
					stack.push(secondQueue.queue[j]);
					secondQueue.remove();
				}
			}
		}
		while(!stack.isEmpty()) {
			secondQueue.add(stack.pop());
		}
	}
	
}