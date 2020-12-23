package question16;

import java.io.*;

public class UsingIndex {
	//not working correctly, bcz one case havn't considered,so think about edge cases as well
	//O(n) time 						O(1) space
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter n : ");
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		System.out.println("Enter array elements : ");
		String str[]=br.readLine().trim().split(" ");
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(str[i]);
		}
		System.out.println("Enter k : ");
		int k=Integer.parseInt(br.readLine());
		
		System.out.println("Sum : "+findSum(array,n,k));
	}
	
	static int findSum(int array[],int n,int k) {
		int sum=0;
		int i=0,j=0;
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		
		while(i<=n-k) {
			
			if(array[j]<min) {
				min=array[j];
			}
			
			if(array[j]>max) {
				max=array[j];
			}
			
			if(j-i+1==k) {
				sum+=(min+max);
				if(min==array[i]) {
					min=Integer.MAX_VALUE;
				}
				if(max==array[i]) {
					max=Integer.MIN_VALUE;
				}
				i++;
			}
			j++;
		}
		
		return sum;
	}
}
