package question_24;
import java.io.*;
import java.util.*;

public class UsingArrays {		//O(n)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int n=Integer.parseInt(br.readLine());
		int array[]=new int[500];
		array[0]=1;
		int len=1;
		for(int i=2;i<=n;i++) {
			len=multiply(i,array,len);
		}
		
		for(int i=len-1;i>=0;i--) {
			System.out.print(array[i]);
		}
	}
	
	static int multiply(int x,int array[],int len) {
		int carry=0;
		
		for(int i=0;i<len;i++) {
			int prod=array[i]*x+carry;
			System.out.println(prod+"--------");
			array[i]=prod%10;
			carry=prod/10;
		}
		
		while(carry!=0) {
			array[len]=carry%10;
			carry=carry/10;
			len++;
		}
		return len;
	}

}
