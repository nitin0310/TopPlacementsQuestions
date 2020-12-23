package question2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UsingLinkedHashSet {
	//O(1) time										O(1) space
	static LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<Integer,Integer>();
	static int N;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter cache size : ");
		int n = Integer.parseInt(br.readLine());
		N=n;
		System.out.println("Enter query count : ");
		int queries = Integer.parseInt(br.readLine());
		
		while(queries!=0) {
			System.out.println("Enter query : \n1 : set\n2 : get");
			int choice = Integer.parseInt(br.readLine());
			int key;
			switch(choice) {
			case 1:
				System.out.println("Enter key");
				key = Integer.parseInt(br.readLine());
				System.out.println("Enter value");
				int value = Integer.parseInt(br.readLine());
				set(key,value);
				break;
			case 2:
				System.out.println("Enter key");
				key = Integer.parseInt(br.readLine());
				System.out.println(get(key));
				break;
			}
			queries--;
		}
	
	}
	
	static void set(int key,int value) {//O(1)
		if(linkedHashMap.size()==N) {
			int firstKey=-1;
			for(Map.Entry<Integer, Integer> e:linkedHashMap.entrySet()) {
				firstKey=e.getKey();//to get first key bcz when size reaches we need to remove first pair, and it inserts elements in insertion order
				break;
			}
			linkedHashMap.remove(firstKey);//O(1)
		}
		linkedHashMap.put(key, value);
	}
	
	static int get(int key) {//O(1)
		if(!linkedHashMap.containsKey(key)) {
			return -1;
		}else {
			return linkedHashMap.get(key);//O(1)
		}
	}
}

