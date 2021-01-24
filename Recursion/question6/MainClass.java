package question6;

public class MainClass {
	//hard category --and did it by myself
	public static void main(String args[]) {
		int n=4;
		int output[]=new int[n];
		 findBinaryValues(n,n,output,0,0);
	}
	
	static void findBinaryValues(int n,int k,int[] output,int index,int targetSum) {
		int sum=0;
		if(k==0) {
			if(n%2==0) {
				if(findSum(output,n/2,n)==targetSum) {
					for(int i=0;i<n;i++) {
						System.out.print(output[i]);
					}
					System.out.println();
				}
			}else {
				if(findSum(output,(n/2)+1,n)==targetSum) {
					for(int i=0;i<n;i++) {
						System.out.print(output[i]);
					}
					System.out.println();
				}
			}
			return;
		}
		
		if(index==n/2) {
			sum=findSum(output,0,n/2);
			output[index]=0;
			findBinaryValues(n,k-1,output,index+1,sum);
			output[index]=1;
			findBinaryValues(n,k-1,output,index+1,sum);
			return;//most important,if we are modifying input in between then try to think should we need to return from here
			//when it successfully executed itself
		}
		
		output[index]=0;
		findBinaryValues(n,k-1,output,index+1,targetSum);
		output[index]=1;
		findBinaryValues(n,k-1,output,index+1,targetSum);
	}
	
	static int findSum(int[] output,int start,int end) {
		int sum=0;
		
		for(int i=start;i<end;i++) {
			sum+=output[i];
		}
		
		return sum;
	}
}
