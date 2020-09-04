package question_10;

import java.io.*;


public class UsingForLoop {			//O(n)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		int result[]=new int[n];
		int j=0,k=0;
		for(int i=0;i<n;i++) {
			if(array[i]<0) {
				result[j++]=array[i];
			}else {
				result[n-k-1]=array[i];
				k++;
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.print(result[i]+" ");
		}
	}
}
