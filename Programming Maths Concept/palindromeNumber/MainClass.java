package palindromeNumber;

import java.util.ArrayList;

public class MainClass {
	public static void main(String args[]) {
		System.out.println(usingExtraSpace(121));
		System.out.println(withoutSpace(121));
	}
	
	//by storing reverse of number
	static boolean usingExtraSpace(int num) {
		ArrayList<Integer> reverse=new ArrayList<Integer>();
		
		int n=num;
		while(n!=0) {
			reverse.add(n%10);
			n=n/10;
		}
		
		for(int i=reverse.size()-1;i>0;i--) {
			if(reverse.get(i)!=num%10) {
				return false;
			}
			num=num/10;
		}
		
		return true;
	}
	
	
	static boolean withoutSpace(int num) {
		int length=0;
		int temp=num;
		
		while(temp!=0) {
			length++;
			temp=temp/10;
		}
		
		
		if(length==1) {
			return true;
		}else{
			int divider=1;
			for(int i=1;i<=length-1;i++) {	//like for 121 it will be 100, to get each value from left side
				divider*=10;
			}
			
			
			temp=num;
			int n=num;
			for(int i=0;i<length;i++) {

				if(n%10 != temp/divider) {
					return false;
				}
				temp=temp%divider;			//make sure to update this,bcz left most digit is eliminated
				n=n/10;
				divider=divider/10;
			}
			
			return true;
		}
	}
}
