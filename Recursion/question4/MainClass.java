package question4;

public class MainClass {
	public static void main(String args[]) {
		generatePermutations("nitin","");
	}
	
	static void generatePermutations(String string,String output) {
		if(string.length()==0) {
			if(checkPalindrome(output,output.length())) {
				System.out.println(output);
			}
			return;
		}
		if(checkPalindrome(output,output.length())) {
			System.out.println(output)
		}
		
		generatePermutations(string.substring(1),output.concat(Character.toString(string.charAt(0))));
		generatePermutations(string.substring(1),output);
	}
	
	static boolean checkPalindrome(String string,int n) {
		int start=0,end=n-1;
		
		while(start<=end) {
			if(string.charAt(start)!=string.charAt(end))
				return false;
			
			start++;
			end--;
		}
		return true;
	}
}
