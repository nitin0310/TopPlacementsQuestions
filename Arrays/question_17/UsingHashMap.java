package question_17;
import java.io.*;
import java.util.*;

public class UsingHashMap {			//O(n)==== repeating allow

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String sizes[]=br.readLine().trim().split(" ");
		
		String array1[]=br.readLine().trim().split(" ");
		String array2[]=br.readLine().trim().split(" ");
		String array3[]=br.readLine().trim().split(" ");
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		for(int i=0;i<array1.length;i++) {
			if(map.containsKey(Integer.parseInt(array1[i]))) {
				map.put(Integer.parseInt(array1[i]),map.get(Integer.parseInt(array1[i]))+1);
			}else {
				map.put(Integer.parseInt(array1[i]), 1);
			}
		}
		
		for(int i=0;i<array2.length;i++) {
			if(map.containsKey(Integer.parseInt(array2[i]))) {
				if(map.get(Integer.parseInt(array2[i]))>0) {
					list.add(Integer.parseInt(array2[i]));
					map.put(Integer.parseInt(array2[i]), map.get(Integer.parseInt(array2[i]))-1);
				}
			}
		}
		
		map.clear();
		
		for(int i=0;i<list.size();i++) {
			if(map.containsKey(list.get(i))) {
				map.put(list.get(i), map.get(list.get(i))+1);
			}else {
				map.put(list.get(i), 1);
			}
		}
		
		list.clear();
		
		for(int i=0;i<array3.length;i++) {
			if(map.containsKey(Integer.parseInt(array3[i]))) {
				if(map.get(Integer.parseInt(array3[i]))>0) {
					list.add(Integer.parseInt(array3[i]));
					map.put(Integer.parseInt(array3[i]), map.get(Integer.parseInt(array3[i]))-1);
				}
			}
		}
		
		Iterator itr=list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		
	}

}
