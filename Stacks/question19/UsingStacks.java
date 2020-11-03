package question19;
import java.util.*;

public class UsingStacks {

	public static void main(String[] args) {
		int matrix[][]={{0, 0, 1, 0},
           				{0, 0, 1, 0},
           				{0, 0, 0, 0},
           				{0, 0, 1, 0}};

		checkCelebrity(matrix);

	}
	
	//condition when celebrity doesn't knows anyone--anyone
	//and everyone--everyone knows celebrity
	//in this case max 1 celebrity is possible and min 0
	
	static void checkCelebrity(int[][] matrix) {
		Stack<Integer> stack=new Stack<Integer>();
		
		int count=0;
		for(int i=0;i<matrix.length;i++) {
			stack.push(i);
		}
		
		while(stack.size()>1) {
			int a=stack.pop();
			int b=stack.pop();
			
			if(matrix[a][b]==1) {
				stack.push(b);
			}else {
				stack.push(a);
			}
		}
		int canBe=stack.pop();
		for(int i=0;i<matrix[canBe].length;i++) {
			if(i!=canBe && matrix[canBe][i]==1) {
				System.out.println("none");
				return;
			}
		}
		count++;
		System.out.println(count);
	}

}
