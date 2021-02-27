package variableSizeWindow;
import java.util.*;

//Pick Toys ---given variety of toys as in array, we are restricted to pick max of K type/variety toys,and can pick in continous manner
//variations --Maximize the number of toys that can be purchased with amount K

public class Question4 {
	public static void main(String args[]) {
		String toys="abacab";
		char[] t=toys.toCharArray();
		int maxTypePick=3;
		
		System.out.println(maxPickLength(t,maxTypePick));
	}
	
	//O(n^2) time
	static int maxPickLength(char[] toys,int maxTypePick) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		int start=0;
		int maxLength=Integer.MIN_VALUE;
		
		for(int end=0;end<toys.length;end++) {
			if(!map.containsKey(toys[end])) {
				map.put(toys[end], 1);
			}else{
				map.put(toys[end], map.get(toys[end])+1);
			}
			
			if(map.size()>maxTypePick) {
				while(map.size()>maxTypePick) {
					if(map.get(toys[start])==1) {
						map.remove(toys[start]);
					}else {
						map.put(toys[start], map.get(toys[start])-1);
					}
					start++;
				}
			}
			
			if(map.size()>maxLength){
				maxLength=map.size();
			}
		}
		
		return maxLength;
	}
}
