package question10;

public class UsingRecursion {
	public static void main(String args[]) {
		printFirstUpperCase("abKldL");
	}
	
	static void printFirstUpperCase(String string) {
		if(string.length()==0)
			return;
		
		String str=string.toUpperCase();
		if(string.charAt(0)==str.charAt(0)) {
			System.out.println(str.charAt(0));
			return;
		}
		printFirstUpperCase(string.substring(1));
	}
}
