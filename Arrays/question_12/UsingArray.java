package question_12;

import java.io.*;
public class UsingArray {		//O(n)

	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int array[]=new int[n];
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		int lastValue=array[n-1];
		for(int i=n-1;i>0;i--) {
			array[i]=array[i-1];
		}
		
		array[0]=lastValue;
		
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		
	}

}
