package question19;
import java.util.*;

public class UsingBruteforce {
	//O(n^2) --time					O(1) --space
	public static void main(String[] args) {
		int matrix[][]={{0, 0, 1, 0},
		           		{0, 0, 1, 0},
		           		{0, 0, 0, 0},
		           		{0, 0, 1, 0}};
		
		checkCelebrity(matrix);
	}

	static void checkCelebrity(int m[][]) {
		int count=0;
		
		for(int i=0;i<m.length;i++) {
			int flag=0;
			for(int j=0;j<m[i].length;j++) {
				if(i!=j && m[i][j]==1) {
					flag=1;
				}
			}
			if(flag==0) {
				count++;
			}
		}
		
		if(count==0) {
			System.out.println("No celebrity");
		}else {
			System.out.println(count);
		}
	}
	
}
