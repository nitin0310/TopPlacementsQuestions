package question_14;

import java.io.*;
import java.util.*;

public class usingHashMap {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
		
		
		int len=Integer.parseInt(br.readLine());
		int sum=Integer.parseInt(br.readLine());
		int array[]=new int[len];
		
		for(int i=0;i<len;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<len;i++) {
			if(!hmap.containsKey(array[i])) {
				hmap.put(array[i], 0);
			}else {
				hmap.put(array[i], hmap.get(array[i])+1);
			}
		}
		
		int countTwice=0;
		for(int i=0;i<len;i++) {
			if(hmap.get(sum-array[i])!=null) {
				countTwice+=hmap.get(sum-array[i]);
			}
			
			if (sum-array[i] == array[i]) 
                countTwice--; 
		}
		
		System.out.println("count : "+(countTwice/2));
	}

}
