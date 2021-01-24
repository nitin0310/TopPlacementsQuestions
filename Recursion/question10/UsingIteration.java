package question10;

public class UsingIteration {
	public static void main(String args[]) {
		firstUppercase("abcK");
	}
	
	static void firstUppercase(String string) {
		String str=string.toUpperCase();
		for(int i=0;i<string.length();i++) {
			if(str.charAt(i)==string.charAt(i)) {
				System.out.println(string.charAt(i));
				return;
			}
		}
	}
	
}
