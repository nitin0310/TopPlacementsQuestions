package question11;

import java.util.Arrays;

public class MainClass {
	public static void main(String args[]) {
		String string="cab";
		char[] input=string.toCharArray();
		Arrays.sort(input);
		String str="";
		for(int i=0;i<input.length;i++)
			str=str.concat(Character.toString(input[i]));
		
		findLexicoPowerSets(str,"");
	}
	
	static void findLexicoPowerSets(String input,String output) {
		if(input.length()==0 && output.length()==0) {//bcz we don't need to print " " empty set
			return;
		}
		
		if(input.length()==0) {
			System.out.println(output);
			return;
		}
		
		findLexicoPowerSets(input.substring(1),output.concat(Character.toString(input.charAt(0))));
		findLexicoPowerSets(input.substring(1),output);
	}
}
