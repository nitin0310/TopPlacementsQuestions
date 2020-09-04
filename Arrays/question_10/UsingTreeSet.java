package question_10;

import java.io.*;
import java.util.*;

public class UsingTreeSet {			//O(n logn)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		TreeMap<Integer,Integer> tr=new TreeMap<Integer,Integer>();
		for(int i=0;i<n;i++) {
			int key=Integer.parseInt(br.readLine());
			tr.put(key, 0);
		}
		
		for(Map.Entry<Integer, Integer> e:tr.entrySet()) {
			System.out.print(e.getKey()+" ");
		}
	}
}
