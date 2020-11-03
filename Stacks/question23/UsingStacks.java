package question23;

import java.util.*;

public class UsingStacks {
	//did this without even looking for hint, it was asked in google,amazon and nutanix
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter no. of sets : ");
		int num=scan.nextInt();
		int sets[]=new int[num*2];
		
		System.out.println("Enter "+num+" sets : ");
		for(int i=0;i<sets.length;i++) {
			sets[i]=scan.nextInt();
		}
		
		System.out.println("Set entered : ");
		for(int i=0;i<sets.length;i++) {
			System.out.print(sets[i]+" ");
		}
		System.out.println();
		findOverlapped(sets);
		
	}
	
	static void findOverlapped(int sets[]) {
		
		Stack<Integer> stack=new Stack<Integer>();
		int index=0;
		
		while(index<sets.length) {
			if(stack.isEmpty()) {
				stack.push(sets[index]);
				stack.push(sets[index+1]);
			}else {
				if(index<sets.length && sets[index]<=stack.peek()) {
					int tempGreater=stack.pop();
					int tempSmaller=stack.pop();
					
					if(tempSmaller<sets[index]) {
						stack.push(tempSmaller);
					}else {
						stack.push(sets[index]);
					}
					
					if(tempGreater<sets[index+1]) {
						stack.push(sets[index+1]);
					}else {
						stack.push(tempGreater);
					}	
				}else {
					stack.push(sets[index]);
					stack.push(sets[index+1]);
				}
			}
			index=index+2;
		}
		printStack(stack);
	}
	
	static void printStack(Stack<Integer> stack) {
		Iterator itr=stack.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}
}
