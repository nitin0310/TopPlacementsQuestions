package question24;
import java.util.*;

public class UsingRecursion {
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter n : ");
		int n=scan.nextInt();
		
		int values[]=new int[n];
		
		for(int i=0;i<n;i++) {
			values[i]=scan.nextInt();
		}
	}
	
	static void findHistogram(int values,int n) {
		
	}
	
	static int maximum(int a,int b) {
		if(a>b) {
			return a;
		}else {
			return b;
		}
	}
}
