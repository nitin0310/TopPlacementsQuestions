package variableSizeWindow;
import java.util.*;

//Largest sub-string with k distinct characters
//O(n) time
//O(n) space

public class Question2 {
	public static void main(String args[]) {
		String string="abcdbcacb";
		int n=string.length();
		int k=3;
		
		char[] input=string.toCharArray();
		System.out.println(longestSubWithUniqueKChar(input,n,k));
	}
	
	static int longestSubWithUniqueKChar(char[] input,int n,int k) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		
		int start=0;
		int longestSubString=Integer.MIN_VALUE;
		
		for(int end=0;end<n;end++) {
			if(!map.containsKey(input[end])) {
				map.put(input[end], 1);
			}else {
				map.put(input[end], map.get(input[end])+1);
			}
			
			
			if(map.size()==k) {
				if(end-start+1>longestSubString) {
					longestSubString=end-start+1;
				}
			}else if(map.size()>k) {
				if(map.get(input[start])>1) {
					map.put(input[start], map.get(input[start])-1);
				}else {
					map.remove(input[start]);
				}
				start++;
			}
			
		}
		return longestSubString;
	}
}
