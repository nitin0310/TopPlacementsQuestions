package question20;

public class MainClass {
	public static void main(String args[]) {
		printPattern(10,10,false);
	}
	
	static void printPattern(int n,int i,boolean flag) {
		if(i==n && flag) {
			System.out.print(i);
			return;
		}
		
		//tag isliye bcz jb ye ghtega to false ki,jo indicate krega ki ghat ra hai,
		//true indicate krega ki,ab badh rha hai  but ab use >0 na lejaya jaye ab wo badhega and print hoga
		if(i>0 && !flag) {
			System.out.print(i+" ");
			printPattern(n,i-5,false);
		}else {
			System.out.print(i+" ");
			printPattern(n,i+5,true);
		}
	}
}
