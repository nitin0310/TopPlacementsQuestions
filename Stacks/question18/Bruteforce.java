package question18;
import java.util.*;

public class Bruteforce {
	//O(n^2) --time		(1) --space

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("enter size : ");
		int n=scan.nextInt();
		
		int array[]=new int[n];
		for(int i=0;i<n;i++) {
			array[i]=scan.nextInt();
		}
		printNextGreater(array);
	}
	
	static void printNextGreater(int[] array) {
		for(int i=0;i<array.length;i++) {
			int max=array[i];
			int flag=0;
			for(int j=i;j<array.length;j++) {
				if(array[j]>max) {
					System.out.print(array[j]+" ");
					flag=1;
					break;
				}
			}
			if(flag==0) {
				System.out.print(-1+" ");
			}
		}
	}

}
