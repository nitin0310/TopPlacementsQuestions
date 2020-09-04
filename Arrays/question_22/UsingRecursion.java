package question_22;
import java.util.*;
import java.io.*;

public class UsingRecursion {		//O(2^n) --- sensitive case: atleast one element

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String string[]=br.readLine().trim().split(" ");
		int array[]=new int[n];
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(string[i]);
		}
		
		System.out.println("Is there any subset : "+checkTargetSum(array,n,0));
	}
	
	static boolean checkTargetSum(int array[],int n,int sum) {
		if(n<1) {				//less than 1 not allowed
			return false;
		}
		
		if(sum==array[n-1]) {	//the sum we want is contained in array then return true
			return true;
		}
		
		if(array[n-1]<=sum) {
			return (checkTargetSum(array,n-1,sum-array[n-1]) || checkTargetSum(array,n-1,sum));
		}else {
			return checkTargetSum(array,n-1,sum);
		}
		
	}

}
