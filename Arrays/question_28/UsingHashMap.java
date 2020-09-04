package question_28;
import java.util.*;
import java.io.*;

public class UsingHashMap {			//O(n)
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int k=Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		String str[]=br.readLine().trim().split(" ");
		
		int count=n/k;
		
		for(int i=0;i<str.length;i++) {
			if(map.containsKey(Integer.parseInt(str[i]))) {
				map.put(Integer.parseInt(str[i]),map.get(Integer.parseInt(str[i]))+1);
			}else {
				map.put(Integer.parseInt(str[i]), 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> e:map.entrySet()) {
			if(e.getValue()>count) {
				System.out.print(e.getKey()+" ");
			}
		}
		
	}
}
