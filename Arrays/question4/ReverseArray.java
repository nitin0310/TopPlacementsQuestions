package question4;

import java.io.*;

public class ReverseArray {
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int array[]=new int[n];
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=array.length-1;i>=0;i--) {
			System.out.print(array[i]+" ");
		}
	}
}
