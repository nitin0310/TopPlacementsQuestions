package question_22;
import java.io.*;
import java.util.*;

public class UsingSet {		//O(n)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int sum=Integer.parseInt(br.readLine());
		String string[]=br.readLine().trim().split(" ");
		int array[]=new int[n];
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(string[i]);
		}
	
		System.out.println("found : "+checkForSubArray(array,0,n));
	}
	
	static boolean checkForSubArray(int array[],int sum,int n) {
		
		//eg. 3 -4 4
		//3 usme add kre -4 =-1 and fir add kre 4 =3 to obvoiusly 3 to exist krega hi na
		//pehle se set me ----> that means pair hai jo zero bna paa rha hai
		
		HashSet<Integer> hs=new HashSet<Integer>();
		
		for(int i=0;i<n;i++) {
			
			sum+=array[i];
			
			if(array[i]==0 || sum==0 || hs.contains(sum)) {
				return true;
			}
			
			hs.add(sum);
		}
		
		return false;
	}

}
