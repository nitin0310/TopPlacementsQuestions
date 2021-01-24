package question22;

public class MainClass {
	public static void main(String args[]) {
		int x=100;
		int n=3;
		System.out.println(findCombinations(x,n,1));
	}
	
	static int findCombinations(int x,int n,int i) {
		
		int val=(int)(x-Math.pow(i, n));
		if(val==0) {
			return 1;
		}
		
		if(val<0) {
			return 0;
		}
		
		return (findCombinations(val,n,i+1)+findCombinations(x,n,i+1));
	}
}
