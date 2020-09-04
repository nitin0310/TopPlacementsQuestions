package question_18;

import java.io.*;
import java.util.*;

public class UsingHashMap {		//O(n)
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		String array[]=br.readLine().trim().split(" ");
		
		for(int i=0;i<array.length;i++) {
			if(map.containsKey(Integer.parseInt(array[i]))) {
				map.put(Integer.parseInt(array[i]), map.get(Integer.parseInt(array[i]))+1);
			}else {
				map.put(Integer.parseInt(array[i]), 1);
			}
		}
		
		for(int i=0;i<array.length;i++) {
			if(map.containsKey(Integer.parseInt(array[i]))) {
				if(map.get(Integer.parseInt(array[i]))>1) {
					System.out.println(Integer.parseInt(array[i]));
					break;
				}
			}
		}
		
	}
}
