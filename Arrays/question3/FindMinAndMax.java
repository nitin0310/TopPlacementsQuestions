package question3;
import java.io.*;

public class FindMinAndMax {
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		int array[]=new int[n];
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		System.out.println("Min number : "+findMinimum(array));
		System.out.println("Max number : "+findMaximum(array));
	}
	
	static int findMinimum(int array[]) {
		int minimum=array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i]<minimum) {
				minimum=array[i];
			}
		}
		return minimum;
	}
	
	static int findMaximum(int array[]) {
		int maximum=array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i]>maximum) {
				maximum=array[i];
			}
		}
		return maximum;
	}
}
