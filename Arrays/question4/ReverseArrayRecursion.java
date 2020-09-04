package question4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArrayRecursion {
public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int array[]=new int[n];
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		printReverse(array,n);
	}

	static void printReverse(int array[],int n) {
		if(n<0) {
			return;
		}
		
		System.out.print(array[n-1]+" ");
		printReverse(array,n-1);
	}
}
