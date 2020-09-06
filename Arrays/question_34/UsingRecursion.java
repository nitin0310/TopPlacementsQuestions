package question_34;
import java.io.*;
import java.util.*;

public class UsingRecursion {		//O(n^2) 
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int sum=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		int array[]=new int[n];
		
		for(int i=0;i<n;i++)
			array[i]=Integer.parseInt(str[i]);
		
		System.out.println(find3Numbers(array,n,sum));
	}
	
	static boolean find3Numbers(int A[], int arr_size, int sum) {
		
	// Fix the first element as A[i] 
	for (int i = 0; i < arr_size - 2; i++) { 

	// Find pair in subarray A[i+1..n-1] 
	// with sum equal to sum - A[i] 
	HashSet<Integer> s = new HashSet<Integer>(); 
	int curr_sum = sum - A[i]; 
	for (int j = i + 1; j < arr_size; j++) { 
		if (s.contains(curr_sum - A[j])) { 
			System.out.printf("Triplet is %d, %d, %d ", A[i],A[j], curr_sum - A[j]); 
				return true; 
			} 
			s.add(A[j]); 
		} 
	} 
	
	// If we reach here, then no triplet was found 
	return false; 
	} 
}
