package minJumpsToReachEnd;

public class BuildingLadder {
	public static void main(String args[]) {
		int arr[]= {1,4,3,7,1,2,6,7,6,10};
		System.out.println(minJumps(arr));
	}
	
	static int minJumps(int[] arr) {
		
		if(arr.length<=1) return 0;
		
		if(arr[0]==0) return -1;
		
		int maxReach=arr[0];									//build a ladder, from 0 to value at index 0
		int steps=arr[0];
		int jumps=1;											//bcz we have build a ladder from 0, so already made a jump
		
		for(int i=1;i<arr.length;i++) {
			
			if(i==arr.length-1) return jumps;					//reached end
			
			if(i+arr[i]>maxReach) maxReach=arr[i]+i;			//if we found a ladder that can reach more
			
			steps--;											//every time we are making a step
			
			if(steps==0) {										//if no steps left in ladder then,change the ladder,we have to jump to another ladder
				 jumps++;
				 
				 if(i>=maxReach) return -1;						//we can't reach there anyhow
					
				steps=maxReach-i;								//we made a step or either changed ladder,must update steps
			}
			
		}
		
		
		return jumps;
	}
}
