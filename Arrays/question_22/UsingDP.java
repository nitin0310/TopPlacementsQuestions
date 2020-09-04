package question_22;

import java.io.*;
import java.util.*;

public class UsingDP {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String string[]=br.readLine().trim().split(" ");
		int array[]=new int[n];
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(string[i]);
		}
		
		boolean t[][]=new boolean[n+1][1];
		System.out.println("Check target sum : "+checkTargetSum(array,t,n,0));
		
	}
	
	static boolean checkTargetSum(int array[],boolean t[][],int n,int sum) {
		
		
			for(int j=0;j<=sum;j++) {
				t[0][j]=false;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<=sum;j++) {
					if(array[i]==j) {
						t[i][j]=true;
					}
				}
			}
		
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<=sum;j++) {
				
				if(array[i-1]<=j) {
					t[i][j]=t[i-1][j-array[i-1]] || t[i-1][j];
				}else {
					t[i][j]=t[i-1][j];
				}
				
			}
		}
		
		return t[n][sum];
	}

}
