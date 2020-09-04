package question_11;
import java.io.*;
import java.util.*;

public class UnionUsingSet {		//O(n+m)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		long arr1len=Integer.parseInt(br.readLine());
		long arr2len=Integer.parseInt(br.readLine());
		HashSet<Integer> hset=new HashSet<Integer>();
		
		for(long i=0;i<arr1len;i++) {
			hset.add(Integer.parseInt(br.readLine()));
		}
		
		for(long j=0;j<arr2len;j++) {
			hset.add(Integer.parseInt(br.readLine()));
		}
		
		System.out.println("output : "+hset.size());
	}
}
