package question14;

import java.io.*;

public class UsingIndexes {
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
	
	//---------- not completed -----------
	static void findFirstNeg(int[] array,int n,int k) {
		int i=0;
		int endIndex=i+k-1;
		int startIndex=0;
		
		while(i<=n-k) {
			if(array[i]<0 && i<=endIndex) {
				System.out.print(array[i]+" ");
				startIndex=endIndex;
				i=startIndex;
				endIndex++;
			}else {
				if(i==endIndex) {
					System.out.print(0+" ");
				}
				i++;
			}
		}
	}
}
