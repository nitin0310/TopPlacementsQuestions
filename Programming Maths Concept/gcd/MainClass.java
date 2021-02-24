package gcd;

public class MainClass {
	public static void main(String args[]) {
		
	}
	
	//by subtracting, greater - smaller			--O(n) time
	static int findGCD(int a,int b) {
		
		if(a==0) return b;
		
		if(b==0) return a;
		
		if(a%b==0) {			//or we can also say a==b
			return b;
		}
		
		return a>b ? findGCD(a-b,b):findGCD(b-a,a);
	}
	
	
	//by euclid modulo				--O( log(max(a,b) ) time
	static int euclidGCD(int a,int b) {
		
		if(b==0) return a;
		
		return euclidGCD(b,a%b);
	}
}
