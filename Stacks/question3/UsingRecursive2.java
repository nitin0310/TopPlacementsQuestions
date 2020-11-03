package question3;
import java.util.*;


public class UsingRecursive2 {
	
	//O(n*n) --time bcz 1st recursive call to n time hogi hi..then second fun()
	//recursive calls maximum n times bhi ho skti hai so that's why n*n
	
	//O(1) --space
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);
		
		Iterator itr=stack.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
		sortTheStack(stack);
		
		Iterator itr2=stack.iterator();
		
		System.out.println();
		while(itr2.hasNext()) {
			System.out.print(itr2.next()+" ");
		}
	}
	
	static void sortTheStack(Stack stack) {
		//while calling recursion,we are holding values and trying to make our stack empty
		if(stack.isEmpty())
			return;
		
		int holdedValue=(int)stack.pop();
		sortTheStack(stack);
		
		//when above fun() return every time then we have holded value to insert in the stack 
		sortInserted(stack,holdedValue);
		//the above fun() help to insert it in sorted order
	}
	
	static void sortInserted(Stack stack,int value) {
		//we can do it with loops as well but it is restricted in question
		
		//agar empty hai to direct daal do ya peek wala smaller then obviously below
		//it sbhi smaller hi honge..so puch kr denge direct
		if(stack.isEmpty() || (int)stack.peek()<value) {
			stack.push(value);
			return;
		}
		
		//else condition hai..agar value greater nhi hai matlab shi position dhundhni pdegi
		//shifting hogi kuhch elements ki ..to recursion se shifting kr lenge
		int removedValue=(int)stack.pop();
		sortInserted(stack,value);
		stack.push(removedValue);
		
	}
}
