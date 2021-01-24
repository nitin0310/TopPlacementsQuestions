package question3;

public class MainClass {
	public static void main(String args[]) {
		int array[]={1,2,3,2,1,};
		int n=array.length;
		
		System.out.println(isPalindrome(array,n,0,n-1));
	}
	
	static boolean isPalindrome(int[] array,int n,int startIndex,int endIndex) {
		if(n==0)//no chance to check
			return false;
		
		if(n==1)//it must be palindrome
			return true;
		
		//if we find any pair not related, we return false immediately
		if(array[startIndex]!=array[endIndex]) {
			return false;
		}
		
		System.out.println("startIndex----"+startIndex+" "+array[startIndex]);
		System.out.println("endIndex----"+endIndex+" "+array[endIndex]);
		//reducing the array,bcz we have checked for outer values
		isPalindrome(array,n-2,++startIndex,--endIndex);//take care of operator
		
		//for string we can make use of isPalindrome( string.substring(1,string.length()-1) )
		return true;
	}
}
