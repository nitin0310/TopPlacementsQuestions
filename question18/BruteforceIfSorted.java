package question18;

import java.io.*;

public class BruteforceIfSorted {
	//O(n) time										O(1) space
	//but restricted in O(1)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter string : ");
		String str=br.readLine();
		
		findNonRep(str);
	}
	
	static void findNonRep(String string) {
		if(string.length()==0) {
			System.out.println(-1+" !Enter valid string");
		}else {
			char hold=string.charAt(0);
			System.out.print(hold);
			for(int i=1;i<string.length();i++) {
				if(string.charAt(i)==hold) {
					System.out.print(-1);
				}else {
					System.out.print(string.charAt(i));
					hold=string.charAt(i);
				}
			}
		}
		
	}
}
