package question8;

import java.io.*;
import java.util.*;

public class UsingPriorityQueue {

	public static void main(String[] args) throws IOException{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pr=new PriorityQueue<Integer>();
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(br.readLine());
			pr.add(value);
		}
		
		while(!pr.isEmpty()) {
			System.out.print(pr.poll()+" ");
		}
	}

}
