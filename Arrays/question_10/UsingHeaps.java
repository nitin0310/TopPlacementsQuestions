package question_10;

import java.io.*;
import java.util.*;

public class UsingHeaps {
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pr=new PriorityQueue<Integer>();
		
		for(int i=0;i<n;i++) {
			pr.add(Integer.parseInt(br.readLine()));
		}
		
		while(!pr.isEmpty()) {
			System.out.print(pr.poll()+" ");
		}
	}
}
