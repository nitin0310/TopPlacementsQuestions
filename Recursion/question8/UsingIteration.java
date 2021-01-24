package question8;

public class UsingIteration {
	public static void main(String args[]) {
		System.out.println(countConsonants("abc de"));
	}
	
	static int countConsonants(String string) {
		int count=0;
		for(int i=0;i<string.length();i++) {
			if(isConsonants(string.charAt(i)))
				count++;
		}
		
		return count;
	}
	
	static boolean isConsonants(char c) {
		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c==' ')
			return false;
		
		return true;
	}
}
