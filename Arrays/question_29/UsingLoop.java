package question_29;
import java.io.*;
import java.util.*;

public class UsingLoop {		//O(n)
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		int array[]=new int[n];
		int ranges=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(str[i]);
		}
		
		while(ranges>0) {
			String range[]=br.readLine().trim().split(" ");
			int lr=Integer.parseInt(range[0]);
			int ur=Integer.parseInt(range[1]);
			System.out.println(findGCD(array,lr,ur));
			ranges--;
		}
		
	}
	
	static int findGCD(int array[],int lowerRange,int upperRange) {
		
		int result=array[lowerRange];
		for(int i=lowerRange+1;i<=upperRange;i++) {
			result = GCD(result,array[i]);
		}
		return result;
	}
	
	static int GCD(int m,int n) {
		int r=0;						//to hold remainder
		if(n==0) {
			return 0;					
		}else {
			while(n!=0) {				
				r=m%n;
				m=n;
				n=r;
			}
			return m;
		}
	}
}
