package question_25;
import java.io.*;
import java.util.*;

public class SimilarToKadaneAlgorithm {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		int array[]=new int[str.length];
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(str[i]);
		}
		
		System.out.println("max product subarray : "+findMaxProdSubArray(array,n));

	}
	
	static int findMaxProdSubArray(int array[],int len) {
		
		int max=1,min=1;
		int overallMax=1;
		
		for(int i=0;i<len;i++) {
			
			if(array[i]<0) {
				max=maximum(min*array[i],1);
				min=array[i]*max;
			}else if(array[i]>0) {
				max=array[i]*max;
				min=minimum(1,min*array[i]);
			}else {
				max=min=1;
			}
			
			overallMax=maximum(overallMax,max);
			
		}
		return overallMax;
	}
	/**
	 simple funda - harr ek element k liye track krenge ki agar use sub array me
	 add me le liya jaaye to max and min values kya ho skti hai ,
	 max isliye kyuki hume max chaiye
	 min isliye kyunki wo a tk ki sbse minimum value hogi ek sub array ki ,agar use 
	 ek or -ve mil jayega to wo sbse badi value ban jayegi.that's why
	 */
	static int maximum(int a,int b) {
		if(a<b)
			return b;
		else
			return a;
	}
	
	static int minimum(int a,int b) {
		if(a<b)
			return a;
		else
			return b;
	}
	
}
