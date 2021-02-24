package primeNumber;

import java.util.Arrays;

public class MainClass {
	public static void main(String args[]) {
		int n=7;
		System.out.println(usingLoop(n));
		System.out.println(usingSqrtRoot(n));
		boolean[] isPrime=sieveOfEratoSthenes(n);		//calling for pre-processing
		System.out.println(primeCheckerUsingSieveOfEratoSthenes(isPrime,n));
	}
	
	//starting from 2 and checking for each number	--O(n) time
	static boolean usingLoop(int n) {
		for(int i=2;i<n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
	//we know the fact that if any number is not divisible by 2 to sqrt of that number
	//then no other than itself, can divide that		--O(sqrt(n)) time
	static boolean usingSqrtRoot(int n) {
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				return false;
			}
		}
		
		return true;
	}//but for each test case, it will calculate sqrt
	
	
	
	
	//O(n * log(log(n))) time
	static boolean[] sieveOfEratoSthenes(int n) {
		boolean[] isPrime=new boolean[n+1];
		
		Arrays.fill(isPrime, true);
		
		isPrime[0]=false;
		isPrime[1]=false;
		
		for(int i=2;i<n;i++) {				//checking for each number before n,bcz n can divide itself
			for(int j=2*i;j<=n;j*=2) {		//marking each multiple of i as false, bcz if they are multiple they can't be prime numbers
				
				isPrime[j]=false;
			
			}
		}
		
		return isPrime;
	}
	
	static boolean primeCheckerUsingSieveOfEratoSthenes(boolean[] isPrime,int n) {
		return isPrime[n];		//already pre-processed, just return result for each test case
	}
}
