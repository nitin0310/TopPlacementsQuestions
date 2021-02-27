package fixedSizeWindow;
import java.util.*;

//Count occurrences of anagrams
//O(n*m) 	--(n) length of string, (m) no. of unique values in given substring
//O(m) space

//else by naive,creating all anagram then checking one by one, all, O(N!)

public class Question3 {
	public static void  main(String args[]) {
		String string="aabaabaa";
		String substring="aaba";
		
		char[] str=string.toCharArray();
		char[] sub=substring.toCharArray();
		
		System.out.println(countOccurrences(str,sub));
	}
	
	//can also do with map as well
	static int countOccurrences(char[] string,char[] sub) {
		int subStrCharCount[]=new int[256];
		int anagramCharCount[]=new int[256];
		
		int countOfOccurrence=0;
		int windSize=sub.length;
		int n=string.length;
		int start=0;
		
		Arrays.fill(subStrCharCount, 0);
		Arrays.fill(anagramCharCount, -1);
		
		for(int i=0;i<sub.length;i++) {
			subStrCharCount[sub[i]]++;
			anagramCharCount[sub[i]]=0;
		}
		
		
		for(int end=0;end<n;end++) {
			anagramCharCount[string[end]]++;
			
			if(end-start+1==windSize) {
				
				if(checkCount(sub,subStrCharCount,anagramCharCount)) {
					countOfOccurrence++;
				}
				anagramCharCount[string[start]]--;
				start++;
			}
		}
		
		return countOfOccurrence;
	}
	
	
	static boolean checkCount(char[] givenSubString,int[] subString,int[] anagram) {
		for(int i=0;i<givenSubString.length;i++) {
			if(subString[givenSubString[i]] != anagram[givenSubString[i]]) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 the thing we understood is like given substring - for, then its all anagram size must be 3,
	 and all anagram must have( 1 f, 1 o, 1 r )in it
	 
	 so the window can be of 3 size, and every window must contain same frequency, then we can call it anagram of substring
	 then slide window and remove start index character
	 
	 */
}
