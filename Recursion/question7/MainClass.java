package question7;

public class MainClass {
	public static void main(String args[]) {
		printDigits("123","");
	}
	
	static void printDigits(String input,String output) {
		if(input.length()==1) {
			System.out.println(output.concat(Character.toString(input.charAt(0))));
			return;
		}
		
		printDigits(input.substring(1),output.concat(Character.toString(input.charAt(0))+" "));
		printDigits(input.substring(1),output.concat(Character.toString(input.charAt(0))));
	}
}
