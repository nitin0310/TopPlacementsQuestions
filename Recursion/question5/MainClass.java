package question5;

public class MainClass {
	public static void main(String args[]) {
		findBinary(4,"");
	}
	
	static void findBinary(int k,String output) {
		if(k==0) {
			System.out.println(output);
			return;
		}
		
		if(output.length()==0) {
			findBinary(k-1,output.concat(Integer.toString(0)));
			findBinary(k-1,output.concat(Integer.toString(1)));
			return;//if we don't do this then, after their completion it will check if-else again print all values
		}
		
		if(output.length()>0 && isLastOne(output)) {
			findBinary(k-1,output.concat(Integer.toString(0)));
		}else {
			findBinary(k-1,output.concat(Integer.toString(0)));
			findBinary(k-1,output.concat(Integer.toString(1)));
		}
	}
	
	static boolean isLastOne(String string) {
		//getting character
		//converting character to string
		//getting string to integer
		if(Integer.parseInt(Character.toString(string.charAt(string.length()-1)))==1)
			return true;
		else
			return false;
	}
}
