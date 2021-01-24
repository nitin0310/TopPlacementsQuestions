package question14;

public class MainClass {
	public static void main(String args[]) {
		int array[]= {2,19,4,7,11,13};
		System.out.println(findMaximum(array,array.length));
		System.out.println(findMinimum(array,array.length));
	}
	
	static int findMaximum(int[] array,int n) {
		if(n==1)//base condition
			return array[0];
		
		return max(findMaximum(array,n-1),array[n-1]);//hypothesis,induction
	}
	
	static int findMinimum(int[] array,int n) {
		if(n==1)//base condition
			return array[0];
		
		return min(findMinimum(array,n-1),array[n-1]);//hypothesis,induction
	}
	
	static int max(int a,int b) {
		return a>b?a:b;
	}
	
	static int min(int a,int b) {
		return a<b?a:b;
	}
}
