package question9;

import java.io.*;
import java.util.Arrays;

public class UsingMergeSort {			//O(n logn)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}		//O(1)
		
		Arrays.sort(array);
		System.out.println("range of array : "+(array[n-1]-array[0]));
	}

}
