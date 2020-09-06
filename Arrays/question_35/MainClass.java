package question_35;
import java.util.*;

public class MainClass {
	public static void main(String args[]){
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter n : ");
		int n=scan.nextInt();
		System.out.println("Enter m : ");
		int m=scan.nextInt();
		
		int matrix[][]=new int[n][m];
		System.out.println("Enter matrix elements : ");
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				matrix[i][j]=scan.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
