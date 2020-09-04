package question6;
import java.io.*;
import java.util.Arrays;

public class FindKthElementUsingMergeSort{
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int k=Integer.parseInt(br.readLine());
		int totalElements=Integer.parseInt(br.readLine());
		
		int array[]=new int[totalElements];
		for(int index=0;index<totalElements;index++) {
			array[index]=Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(array);			//mergeSort -O(n logn)
		
		System.out.println("Kth largest : "+array[totalElements-k]);
		System.out.println("Kth smallest : "+array[k-1]);
	}
}