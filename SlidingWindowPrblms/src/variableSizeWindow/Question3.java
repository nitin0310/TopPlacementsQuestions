package variableSizeWindow;
import java.util.*;

//Length of largest sub-string with no repeating characters
//O(n^2) time,in worst case
//O(n) space

public class Question3 {
	public static void main(String args[]) {
		String string="geeksforgeeks";
		char[] input=string.toCharArray();
		int n=string.length();
		
		System.out.println(longestSubStringWithoutRepeating(input,n));
		System.out.println(longestSubStringWithoutRepeating2(input,n));
	}
	
	static int longestSubStringWithoutRepeating(char[] input,int n) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		
		int start=0;
		int longestSubString=Integer.MIN_VALUE;
		
		for(int end=0;end<n;end++) {
			if(!map.containsKey(input[end])) {
				map.put(input[end], 1);
			}else {
				map.put(input[end], map.get(input[end])+1);
			}
			
			
			if(map.size()<end-start+1) {
				while(map.size()<end-start+1) {
					if(map.get(input[start])>1) {
						map.put(input[start], map.get(input[start])-1);
					}else{
						map.remove(input[start]);
					}
					start++;
				}
			}else if(end-start+1==map.size()){
				if(end-start+1>longestSubString) {
					longestSubString=end-start+1;
				}
			}
		}
		
		return longestSubString;
	}
	
	
	//O(n) time
	static int longestSubStringWithoutRepeating2(char[] input,int n) {
		int start=0;
		int longestSubString=Integer.MIN_VALUE;
		int[] lastOccurredIndex=new int[256];
		
		Arrays.fill(lastOccurredIndex, -1);
		
		for(int end=0;end<n;end++) {
			
			start=Math.max(lastOccurredIndex[input[end]]+1, start);			//we update start, when we encountered newly added item repeating by comparing it to last occurrence,so update start to its (last occurrence+1) so that, that newly added doesn't repeat
			
			longestSubString=Math.max(longestSubString, end-start+1);		//here start to end contains all elements non repeating,bcz start updated to that index where last repeating is eliminated
			
			lastOccurredIndex[input[end]]=end;								//update last occurrence of current item as end,bcz it is last occurred at end
		}
		
		return longestSubString;
	}
}
