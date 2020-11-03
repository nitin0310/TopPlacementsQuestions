package question14;
import java.util.*;

public class UsingArrayList {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter k: ");
		int k=scan.nextInt();
		
		KStack instance=new KStack();
		instance.push(15, 2);
		
	}



class KStack{
	
	ArrayList<Stack<Integer>> array=new ArrayList<Stack<Integer>>();
	
	void push(int data,int index) {
		System.out.println(array.get(index));
	}
	
	void pop(int index) {
		
	}
}