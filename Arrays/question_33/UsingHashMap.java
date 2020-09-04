package question_33;
import java.io.*;
import java.util.*;

public class UsingHashMap {
	//------O(n) time ,(n) space
	//if not using hash map, we can temporary array as well and keep count of elements
	//work as same as hash map---O(n) space
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		
		
		HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++) {
			if(hashMap.containsKey(Integer.parseInt(str[i]))) {
				hashMap.put(Integer.parseInt(str[i]), hashMap.get(Integer.parseInt(str[i]))+1);
			}else {
				hashMap.put(Integer.parseInt(str[i]), 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry:hashMap.entrySet()) {
			if(entry.getValue()>1) {
				System.out.print(entry.getKey()+" ");
			}
		}
			
	}
}
