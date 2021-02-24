package aPowerB;

public class MainClass {
	public static void main(String args[]) {
		System.out.println(findPowerRecursion(928984954,99));
		System.out.println(findPowerUsingLoop(2,5));
		System.out.println(findPowerUsingModulo(928984954,99,1000000007));	//10^9 + 7, as we know about it
		//now the result we get from above, is multiplied to 10^9 +7, is the actual answer we get by doing a^b 
	}
	
	
	//exponential bcz of the recusive tree
	static int findPowerRecursion(int a,int b) {
		if(b==0) {
			return 1;
		}
		
		if(b==1) {
			return a;
		}
		
		//basically last bit me 1 add kr denge, agar ab last bit 0 hai to even,else 1 hai to odd
		//2 -- 100 , 2 & 100 = 101 that is 3 odd
		return (b&1)==0 ? findPowerRecursion(a,b/2)*findPowerRecursion(a,b/2) : a*findPowerRecursion(a,b-1);
		//we can also do b%2==0
	}
	
	
	//simply, it works as like,
	/*
	  2^5 : odd , it will break as like -- 2 x ((2^2)^5/2)
	 
	  2^8 : even , it will break as like -- ((2^2)^2)^2, this is done by updating b
	 */
	static int findPowerUsingLoop(int a,int b) {
		
		int res=1;
		
		while(b>0) {
			
			if( (b&1) != 0) {	//if odd, only multiply a
				res = res*a;
			}
			
			a = a*a;		//doing square of that
			b = b >> 1;		//dividing power by half
			// x >> y = right shift means, x/(2^y)
			// x << y = left shift means, x*(2^y)
		}
		
		return res;
	}
	
	
	
	//using modulo, above both doesn't works for large numbers
	static long findPowerUsingModulo(long a,long b,int n) {
		/*
		 
		 modulo properties - 
		 (a+b)%n = (a%n + b%n)%n
		 (a-b)%n = (a%n - b%n)%n
		 (a*b)%n = (a%n * b%n)%n
		 
		 */
		
		long res=1;
		
		while(b>0) {
			
			if( (b&1) != 0) {
				res = (res%n * a%n)%n;
			}
			
			a = (a%n * a%n)%n;
			b = b >> 1;
		}
		
		return res;
		
	}
}
