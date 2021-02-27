package minJumpsToReachEnd;

import java.util.Arrays;

public class UsingDP {
	public static void main(String args[]) {
		int arr[]= {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(findMinSteps(arr,arr.length));
	}
	
	//it's actually checking in a kind of reverse way
	static int findMinSteps(int arr[],int n) {
		
		int jumps[] = new int[n];
		Arrays.fill(jumps, Integer.MAX_VALUE);
        
 
        jumps[0] = 0;
 
        //ith is the node, for which we calculate for min distance from 0
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {//it helps to calculate from 0 to i
            	
            	//if reachable then check for all reachable and hold minimum
            	//arr[j]+j tell us where it can reach from it
                if (arr[j]+j>=i && jumps[j] != Integer.MAX_VALUE) {
                    if(jumps[j]+1<jumps[i]) {
                    	jumps[i]=jumps[j]+1;
                    }
                }
            }
        }
        
        return jumps[n-1];
	}
}
