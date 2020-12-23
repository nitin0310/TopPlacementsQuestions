package question16;
import java.io.*;

public class UsingBruteforce {
	//O(nk) time									O(1) space
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
		
		for(int i=0;i<=n-k;i++) {
			int min=Integer.MAX_VALUE;
			int max=Integer.MIN_VALUE;
			for(int j=i;j<i+k;j++) {
				if(array[j]<min) {
					min=array[j];
				}
				
				if(array[j]>max) {
					max=array[j];
				}
			}
			sum+=(min+max);
		}
		
		return sum;
	}
}
