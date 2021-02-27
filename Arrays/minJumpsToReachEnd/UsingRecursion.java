package minJumpsToReachEnd;

public class UsingRecursion {
	public static void main(String args[]) {
		int arr[]= {1,4,3,7,1,2,6,7,6,10};
		int jumps=findMinJumps(arr,0,arr.length-1);
		
		if(jumps<0) {
			System.out.println("can't reach that node!");
		}else {
			System.out.println(jumps);
		}
	}
	

	
	static int findMinJumps(int[] arr,int src,int dest) {
		
		if(src==dest) return 0;						//when we make call from last index to reach last index
		
		if(arr[src]==0) return Integer.MAX_VALUE;
		
		int minJumpsFromHere=Integer.MAX_VALUE;
		
		for(int i=src+1; i<=src+arr[src] && i<=dest ;i++) {
			int jumps=findMinJumps(arr,i,dest);			//make call for all paths it can reach from here
			if(jumps+1<minJumpsFromHere) {				//we get jumps from each path we can reach,so just take min among them
				minJumpsFromHere=jumps+1;
			}
		}
		
		return minJumpsFromHere;
	}
	
	
	
	
	/*
	  0 1 2 3 4 5 6 7 8  9 
	------------------------
	| 1 4 3 7 1 2 6 7 6 10 |
	------------------------
	
	we want => min jumps(0 to 9)
	
	now check where 0 can reach, if 0 can reach there then he would be able to make further call
	
	0 can reach 1 only ===> jumps(1 to 9)
	
	1 can reach 1+4=5 ,, 2 3 4 5 so we want MIN( jumps(2 to 9), jumps(3 to 9), jumps(4 to 9), jumps(5 to 9))
	
	and in this way, at final jumps(9 to 9) return 0;
	
	
	DP can optimize like (5 to 9) called by 2 3 4 5 so instead of calling every time, we can store this answer
	 */
}
