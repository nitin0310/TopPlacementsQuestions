package trailingZero;

//we need to find trailing zero in factorial of a given number
public class MainClass {
	public static void main(String args[]) {
		System.out.println(countTrailingZero(7)); //5040
	}
	
	static int countTrailingZero(int n) {
		int count=0;
		
		//why we are multiplying it by 5, in every iteration, bcz in 25 there exists two five
		//so let 12 contains only  two 2 five 5 and then in 10,
		//but let 32 , 5 10 15 20 but in 25 --two 5, so 32/5 --6 fives but that extra by 32/25 --1 five, that's why
		for(int i=5;i<=n;i*=5) {
			count+=n/i;
		}
		
		return count;
	}
}
