package question1;

public class ReverseString {
	public static void main(String args[]) {
		printReverse("abcde",5);
	}
	
	static void printReverse(String string,int n) {
		if(n==0)//base condition
			return;
		
		System.out.print(string.charAt(n-1));//induction
		printReverse(string,n-1);//hypothesis
	}
}
