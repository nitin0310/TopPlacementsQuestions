package question_27;
import java.io.*;
import java.util.*;

public class UsingBinarySearch {	//O(log) but not for duplicates if any

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		String str[]=br.readLine().trim().split(" ");
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(str[i]);
		}
		
		System.out.println(findMinimum(array,0,n-1));
	}
	
	static int findMinimum(int array[],int low,int high) {
		int minElement;
		int mid=(high-low+1)/2;
		
		if(mid<high && array[mid]>array[mid+1]) {
			return array[mid];
		}
		if(mid>low && array[mid]<array[mid-1]) {
			return array[mid];
		}
		
		if (array[high] > array[mid]) {		//it means right side is ok
            return findMinimum(array, low, mid-1);
		}else {
			return findMinimum(array, mid+1, high);
		}
		
	}

}
