package fixedSizeWindow;

//Maximum sum sub-array of size k
//O(n) time

public class Question1 {
	public static void main(String args[]) {
		int array[]= {100,200,300,400};
		System.out.println(maxSum(array,4,2));
	}
	
	static int maxSum(int[] array,int n,int k) {
		int start=0;
		int sum=0;
		int maxSum=0;
		
		for(int end=0;end<n;end++) {
			sum+=array[end];
			
			if(end-start+1==k) {									//jb window fixed size ki ban jaaye tb update kr do maxSum,and slide kr do
				if(sum>maxSum) maxSum=sum;
				sum-=array[start];
				start++;
			}
		}
		
		return maxSum;
	}
}
