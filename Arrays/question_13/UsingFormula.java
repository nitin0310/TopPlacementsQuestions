package question_13;
import java.io.*;
import java.util.*;

public class UsingFormula {		//O(n)

	// (sum of all natural number till n-1) - (sum of all digits given)
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		while(t>0) {
			int n=Integer.parseInt(br.readLine());
			String str[]=br.readLine().trim().split(" ");
			int array[]=new int[n-1];
			
			int sumOfDigits=0;
			for(int i=0;i<str.length-1;i++) {			//O(n)
				array[i]=Integer.parseInt(str[i]);
				sumOfDigits=sumOfDigits+array[i];
			}
			
			int sumOfNaturalNo=(n*(n-1))/2;		//(n*n+1)/2 	but here n=n-1
			
			System.out.println(sumOfNaturalNo-sumOfDigits);
			t--;
		}
		
	}

}
