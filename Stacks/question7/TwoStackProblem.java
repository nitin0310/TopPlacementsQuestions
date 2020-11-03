package question7;

public class TwoStackProblem {
	public static void main(String[] args) {
		Stack stack=new Stack();
		stack.push1(2);
		stack.push1(3);
		stack.push2(4);
		stack.pop1();
		stack.pop2();
		stack.pop2();
	}

}

class Stack{
	
	int array[],topLeft,topRight;
	
	Stack(){
		array=new int[20];//temporary size
		topLeft=-1;
		topRight=array.length;
	}
	
	void push1(int data) {
		array[++topLeft]=data;
	}
	
	void push2(int data) {
		array[--topRight]=data;
	}
	
	void pop1() {
		if(topLeft<0) {
			System.out.print(-1);
		}else {
			System.out.print(array[topLeft]+" ");
			topLeft--;
		}
	}
	
	void pop2() {
		if(topRight>=array.length) {
			System.out.print(-1);
		}else {
			System.out.print(array[topRight]+" ");
			topRight++;
		}
	}
	
}
