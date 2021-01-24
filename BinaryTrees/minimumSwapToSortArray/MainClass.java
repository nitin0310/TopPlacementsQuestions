package minimumSwapToSortArray;

import java.util.*;

public class MainClass {
	//O(n logn) time--sorting time of ds				O(n) space
	public static void main(String args[]) {
		int[] array= {1,5,4,3,2};
		
		System.out.println(findMinSwapToSort(array));
	}
	
	/*
	 main funda is if we have another array as sorted with same values,
	 then we can compare them as check the values need to swap in sorted array to
	 again form the actual given array,it works like in reverse  from sorted to actual unsorted given
	 but here we can't use predefined Pair<Integer,Integer> so we are using
	 tree map,that help us to keep values sorted
	 */
	static int findMinSwapToSort(int[] array) {
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		int swapCount=0;
		
		//adding each value with its current index of unsorted ordered array
		for(int i=0;i<array.length;i++) {
			map.put(array[i], i);
		}
		
		int index=0;
		while(index<array.length) {
			//it removes first entry every time from tree,i.e the smallest key
			Map.Entry<Integer, Integer> entry=map.pollFirstEntry();
			
			//here each key holds its unsorted index, now it meets that unsorted that means we don't need to swap
			if(entry.getValue()==index) {
				index++;
			}else {
				//f it doesn't meets then we swap the values but as in map value
				int valueInArray=array[index];
				map.put(valueInArray, entry.getValue());
				map.put(entry.getKey(),index);
				
				swapCount++;
			}
		}
		
		return swapCount;
		
	}
}