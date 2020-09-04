package question4;
import java.io.*;
import java.util.*;

public class ReverseUsingStacks {
	public static void main(String[] args) throws IOException{
		
		Stack<Integer> stack=new Stack<Integer>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());
		
		while(n>0) {
			int value=Integer.parseInt(br.readLine());
			stack.push(value);
			n--;
		}
		System.out.println("array : ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}

}
