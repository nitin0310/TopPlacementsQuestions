package question9;

public class MainClass {
	public static void main(String args[]) {
		System.out.println(findLength("abc de"));
	}
	
	static int findLength(String string) {
		if(string.equals(""))
			return 0;
		
		return findLength(string.substring(1))+1;
	}
}
