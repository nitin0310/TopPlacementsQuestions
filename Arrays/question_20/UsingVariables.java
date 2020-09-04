package question_20;

import java.io.*;
import java.util.*;

public class UsingVariables {		//O(n)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String string[]=br.readLine().trim().split(" ");
		int first=Integer.MIN_VALUE,second=Integer.MIN_VALUE,third=Integer.MIN_VALUE;
		int f=0,s=0;
		
		for(int i=0;i<string.length;i++) {	//O(n)
			if(Integer.parseInt(string[i])>first) {
				first=Integer.parseInt(string[i]);
				f=i;
			}
		}
		
		for(int i=0;i<string.length;i++) {	//O(n)
			if(i==f) {
				continue;
			}else {
				if(Integer.parseInt(string[i])>second) {
					second=Integer.parseInt(string[i]);
					s=i;
				}
			}
		}
		
		for(int i=0;i<string.length;i++) {	//O(n)
			if(i==s || i==f) {
				continue;
			}else {
				if(Integer.parseInt(string[i])>third) {
					third=Integer.parseInt(string[i]);
				}
			}
		}
		
		System.out.println(first+" "+second+" "+third);
		
	}

}
