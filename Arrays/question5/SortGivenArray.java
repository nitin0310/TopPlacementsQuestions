package question5;
import java.io.*;
import java.util.Arrays;

public class SortGivenArray {
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		
		for(int value:array) {
			System.out.print(value+" ");
		}
	}
}
