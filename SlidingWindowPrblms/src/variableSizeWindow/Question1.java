package variableSizeWindow;
import java.util.*;

//Largest Sub-array with sum k
//O(n) time
//works for non-negative

public class Question1 {
	public static void main(String args[]) {
		int[] array= {4,1,1,1,2,3,5};
		int n=7;
		int sum=5;
		
		System.out.println(largestSubArray(array,n,sum));
		System.out.println(largestSubArray(array,n,sum));
	}
	
	static int largestSubArray(int[] array,int n,int sum) {
		int start=0;
		int larSize=Integer.MIN_VALUE;
		int currSum=0;
		
		for(int end=0;end<n;end++) {
			currSum+=array[end];
			
			if(currSum>sum) {
				currSum-=array[start];
				start++;
			}else if(currSum==sum) {
				larSize=Math.max(larSize, end-start+1);
			}
		}
		
		return larSize;
	}
	
	/*
	 simply add krte rhenge upcoming,
	 but agar sum exceed kr jaaye to matlab window ko slide kro, start ko remove kro
	 
	 if sum hit ho jaaye, matlab ek subarray mil gyi,uski length dekg lo or largest update kr do, fir again aage badhte rho, next ko add kr k check kro
	 */
	
	
	//can work for -ve as well
	//O(n) time
	//O(n) space
	static int largestSubArray2(int[] array,int n,int sum) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int larSize=Integer.MIN_VALUE;
		int currSum=0;
		
		
		for(int end=0;end<n;end++) {
			currSum+=array[end];
			
			if(currSum==sum) {
				if(end+1>larSize) {
					larSize=end+1;
				}
			}
			
			if(!map.containsKey(currSum)) {
				map.put(currSum, end);
			}
			
			if(map.containsKey(sum-currSum)) {
				int subArrayLen=end-map.get(sum-currSum);
				if(subArrayLen>larSize) {
					larSize=subArrayLen;
				}
			}
		}
		
		return larSize;
	}
	
	/*
	 mainly har item ko add kr lo, means window choti hogi hi nhi kbhi, hmesha increase kregi,bcz ho skta hai sum -ve manga ho or window choti kr k hum koi -ve na bahr nikal de jo helpful tha
	 
	 but ab hum choti nhi kr skte to sbhi sub array ko check kaise krenge,
	 map me sbhi sums ko store kr k
	 
	 agar already stored hai (sum-currSum), to matlab sub array exist krti hai, from index (sum-currSum) to i
	 */
}
