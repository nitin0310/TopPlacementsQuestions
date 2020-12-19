package question17;
import java.io.*;

public class UsingBruteforce {
	//O(n) time									O(1) space
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string : ");
		String str=br.readLine();
		System.out.println("Enter k : ");
		int k=Integer.parseInt(br.readLine());
		char[] array=new char[str.length()-k];
		for(int i=0;i<str.length()-k;i++) {
			array[i]=str.charAt(i);
		}
		System.out.println(array);
		
		System.out.println(findSum(array,array.length));
	}
	
	static int findSum(char[] values,int n) {
		char hold=values[0];//holding 1st char o check further
		int count=1,sum=0;
		
		for(int i=1;i<n;i++) {//bcz already done with char at 0
			if(hold==values[i]) {
				count++;
			}else {
				sum+=(count*count);
				hold=values[i];
				count=1;
			}
		}
		sum+=(count*count);//this is for last char series,bcz it cant reach for last one
		return sum;
	}
	
}
