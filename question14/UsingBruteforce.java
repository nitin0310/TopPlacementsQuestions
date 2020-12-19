package question14;
import java.io.*;

public class UsingBruteforce {
	//O(n*k) time								O(1) space
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n : ");
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		System.out.println("Enter array elements : ");
		String[] str=br.readLine().trim().split(" ");
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(str[i]);
		}
		System.out.println("Enter k : ");
		int k = Integer.parseInt(br.readLine());
		
		findFirstNeg(array,n,k);
	}
	
	static void findFirstNeg(int[] array,int n,int k) {
		boolean flag=false;
		
		for(int i=0;i<=n-k;i++) {
			flag=false;
			for(int j=i;j<(i+k);j++) {
				if(array[j]<0) {
					System.out.print(array[j]+" ");
					flag=true;
				}
			}
			if(!flag) {
				System.out.print(0+" ");
			}
		}
		
	}
	
}