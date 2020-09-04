package question_15;
import java.io.*;
import java.util.*;

public class UsingHashMap {				//O(n)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		
		String str[]=br.readLine().trim().split(" ");
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(str[i]);
			if(!hmap.containsKey(value)) {
				hmap.put(value, 1);
			}else {
				hmap.put(value, hmap.get(value)+1);
			}
		}
		
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(str[i]);
			if(hmap.get(value)>1) {
				System.out.print(value+" ");
				hmap.put(value, 0);
			}
		}
		
		
	}
}
