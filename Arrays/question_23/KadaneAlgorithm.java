package question_23;
import java.io.*;

public class KadaneAlgorithm {		//O(n)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		String string[]=br.readLine().trim().split(" ");
		int array[]=new int[n];
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(string[i]);
		}
		
		System.out.println("Sum : "+findValue(array,n));
	}

	static int findValue(int array[],int n) {
		int maxValue=Integer.MIN_VALUE;		//represents a kind of sum
		int maxEnd=0;				//represents a kind of ,including elements in sub array
		
		for(int i=0;i<n;i++) {
			maxEnd += array[i];
			
			if(maxValue<maxEnd) {
				maxValue=maxEnd;
			}
			
			if(maxEnd<0) {
				maxEnd=0;
			}
		}
		
		return maxValue;
	}
	
	
}
