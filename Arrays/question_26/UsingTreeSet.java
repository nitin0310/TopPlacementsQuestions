package question_26;
import java.util.*;
import java.io.*;

public class UsingTreeSet {	//O(n)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		TreeSet<Integer> set=new TreeSet<Integer>();
		
		
		for(int i=0;i<str.length;i++) {
			set.add(Integer.parseInt(str[i]));
		}
		
		System.out.println("longest consecutive subsequence : "+longestConsecutiveSubsequence(set,n));
		
	}
	
	static int longestConsecutiveSubsequence(TreeSet<Integer> set,int n) {
		
		int lcs=1,maxValue=1;
		int value=set.pollFirst();
		for(int i=1;i<n;i++) {
			int next=set.pollFirst();
			
			if(next==value+1) {
				lcs++;
			}else {
				lcs=1;
			}
			value=next;
			if(maxValue<lcs) {
				maxValue=lcs;
			}
		}
		return maxValue;
	}

}
