package question_11;
import java.util.*;
import java.io.*;

public class IntersectionUsingSet {			//O(n+m)
	public static void main(String args[]) throws IOException{
		HashSet<Integer> hset=new HashSet<Integer>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int arr1len=Integer.parseInt(br.readLine());
		int arr2len=Integer.parseInt(br.readLine());
	
		int intersection=0;
		
		for(int i=0;i<arr1len;i++) {
			hset.add(Integer.parseInt(br.readLine()));
		}
		
		for(int i=0;i<arr2len;i++) {
			int value=Integer.parseInt(br.readLine());
			if(hset.contains(value)) {
				intersection++;
			}
		}
		
		System.out.println("Intersection : "+intersection);
	}
}
