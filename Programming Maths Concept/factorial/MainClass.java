package factorial;

import java.util.ArrayList;

public class MainClass {
	public static void main(String args[]) {
		int smallNum=7;
		System.out.println(factorialOfSmallNum(smallNum));
		
		factorialOfLargeNum(100);
	}
	
	static int factorialOfSmallNum(int n) {
		
		if(n==0 || n==1) {
			return 1;
		}
		
		return n*factorialOfSmallNum(n-1);
	}
	
	
	static void factorialOfLargeNum(int n) {
		ArrayList<Integer> array=new ArrayList<Integer>();
		
		array.add(0,1);//fact of 1 = 1
		
		//hr number ko next se multiply k liye
		for(int i=2;i<=n;i++) {
			array=factHelper(array,i);
		}
		
		//as we are storing in reverse so, at last print in reverse
		for(int i=array.size()-1;i>=0;i--) {
			System.out.print(array.get(i));
		}
	}
	
	static ArrayList<Integer> factHelper(ArrayList<Integer> array,int num) {
		int carry=0;
		
		//simply pick num, multiply it, pick it's last digit add it at same index, then get carry if any, then do same till length
		for(int i=0;i<array.size();i++) {
			int item=array.get(i);
			int mul=(num*item)+carry;
			int lastDigit=mul%10;
			carry=mul/10;
			array.set(i, lastDigit);
		}
		
		//if  > 0, it means new number is increased by one digit, so simply add it and check further the same
		while(carry>0) {
			array.add(carry%10);
			carry=carry/10;
		}
		
		return array;
	}
}
