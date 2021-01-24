package question21;

public class MainClass {
	public static void main(String args[]) {
		int array[]= {2,3};
		findSumOfSubsets(array,array.length,0);
	}
	
	static void findSumOfSubsets(int[] array,int n,int sum) {
		if(n==0) {//base condition
			System.out.print(sum+" ");
			return;
		}
		
		findSumOfSubsets(array,n-1,sum);//include nhi krenge
		findSumOfSubsets(array,n-1,(sum+array[n-1]));//include krenge
	}
}
