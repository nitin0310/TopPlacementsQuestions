package question2;

import java.io.*;
import java.util.Arrays;

public class UsingBinarysearch {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int array[]=new int[m];
		for(int i=0;i<m;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("present? "+checkNumber(array,n));
		

	}
	
	static boolean checkNumber(int array[],int key) {
		Arrays.sort(array);
		if(Arrays.binarySearch(array, key)!=-1) {
			return true;
		}else {
			return false;
		}
	}

}
