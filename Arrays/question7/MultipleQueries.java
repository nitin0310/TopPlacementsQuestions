package question7;
import java.io.*;
import java.util.*;

public class MultipleQueries {
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
		
		//all queries in O(1)
		
		int length=Integer.parseInt(br.readLine());
		
		for(int i=0;i<length;i++) {
			int value=Integer.parseInt(br.readLine());
			if(hmap.containsKey(value)) {
				hmap.put(value,hmap.get(value)+1);
			}else {
				hmap.put(value, 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> e:hmap.entrySet()) {
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
	}
}
