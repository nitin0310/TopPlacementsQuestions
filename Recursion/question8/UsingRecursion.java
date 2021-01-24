package question8;

public class UsingRecursion {
	public static void main(String args[]) {
		System.out.println(countCons("abc de",6));
	}
	
	static int countCons(String string,int n) {
		if(n==0)
			return 0;
		
		int count=countCons(string,n-1);
		if(isCons(string.charAt(n-1)))
			return count+1;
		
		return count;
	}
	
	static boolean isCons(char c) {
		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c==' ')
			return false;
		
		return true;
	}
}
