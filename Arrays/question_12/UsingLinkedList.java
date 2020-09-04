package question_12;

import java.io.*;
import java.util.*;

public class UsingLinkedList {		//O(n)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		LinkedList<Integer> linkedList=new LinkedList<Integer>();
		
		for(int i=0;i<n;i++) {
			linkedList.add(Integer.parseInt(br.readLine()));
		}
		
		int lastValue=linkedList.removeLast();		//O(1)
		
		linkedList.add(0, lastValue);				//O(1)
		
		Iterator itr=linkedList.iterator();
		while(itr.hasNext()) {						//O(n)
			System.out.print(itr.next()+" ");
		}
	}

}
