package question_38;
import java.util.*;

public class UsingLoops {//		O(m*n)
	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		int m=scan.nextInt();
		int n=scan.nextInt();
		
		int matrix[][]=new int[m][n];
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				matrix[i][j]=scan.nextInt();
		
		print(matrix,0,0,m,m);
	}
	
	static void print(int matrix[][],int i,int j,int m,int n) {
		
		//i--row j--col
		if (i >= m || j >= n) 
        { 
            return; 
        }
		
		for(int p=i;p<n;p++) {//00 01 02..0n-1
			System.out.print(matrix[i][p]+" ");
		}
		
		for(int p=i+1;p<m;p++) {//i bcz 1 row ho gyi ab or rows ki baari
			System.out.print(matrix[p][n-1]+" ");
		}
		
		if((m-1)!=i) {
			for(int p=n-2;p>=j;p--) {
				System.out.print(matrix[m-1][p]+" ");
			}
		}
		
		if((n-1)!=j) {
			for(int p=m-2;p>i;p--) {
				System.out.print(matrix[p][j]+" ");
			}
		}
		
		print(matrix,i+1,j+1,m-1,n-1);
	}
	
}
