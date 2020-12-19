package question3;

/*
How to efficiently implement “k” queues in an array.
But not suitable bcz, the inbetween space is in waste when there's
no item stored there.
*/

public class ByDividingInSlots {
	public static void main(String args[]) {
		Queue kQueue = new Queue(2);
		kQueue.enqueue(10, 1);
		kQueue.enqueue(20, 1);
		kQueue.enqueue(30, 1);
		kQueue.enqueue(40, 2);
		kQueue.enqueue(50, 2);
		kQueue.enqueue(60, 2);
		
		kQueue.display(1);
		kQueue.display(2);
		
		kQueue.dequeue(2);
		kQueue.display(2);
		
		kQueue.dequeue(2);
		kQueue.display(2);
	}
}

class Queue{
	
	int k=0;
	Queue(int k){
		this.k=k;
		for(int i=0;i<array.length;i++) {
			array[i]=Integer.MIN_VALUE;//temporary values
		}
	}
	
	int array[]=new int[10];
	
	void enqueue(int data,int queueNo) {
		int startIndex = 0+queueNo*(array.length/k)-array.length/k;
		
		if(array[queueNo*(array.length/k)-1]!=Integer.MIN_VALUE) {
			System.out.println(queueNo+" is full!");
		}else {
			while(array[startIndex]!=Integer.MIN_VALUE) {
				startIndex++;
			}
			array[startIndex]=data;
		}
	}
	
	int dequeue(int queueNo) {
		int lastIndex = queueNo*(array.length/k)-1;
		while(array[lastIndex]==Integer.MIN_VALUE) {
			lastIndex--;
		}
		if(lastIndex>=queueNo*(array.length/k)-array.length/k) {
			int data = array[lastIndex];
			array[lastIndex]=Integer.MIN_VALUE;
			return data;
		}
		
		return -1;
	}
	
	void display(int queueNo) {
		int startIndex = 0+queueNo*(array.length/k)-array.length/k;
		int lastIndex = queueNo*(array.length/k)-1;
		
		while(array[startIndex]!=Integer.MIN_VALUE && startIndex<=lastIndex) {
			System.out.print(array[startIndex]+" ");
			startIndex++;
		}
		System.out.println();
	}
}
