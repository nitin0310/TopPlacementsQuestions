package question_32;
import java.io.*;

public class UsingLoops {
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		int stepsArray[]=new int[n];
		
		for(int i=0;i<n;i++)
			stepsArray[i]=Integer.parseInt(str[i]);
		
		System.out.println(findMinimumSteps(stepsArray,n));
	}
	
	static int findMinimumSteps(int array[],int n) {
		if(n==0 || array[0]==0) {
			return 0;
		}
		
		int jumps[]=new int[n];
		jumps[0]=0;
		
		for(int i=1;i<n;i++) {
			jumps[i]=Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				if(i<=j+array[j] && jumps[j]!=Integer.MAX_VALUE) {
					jumps[i]=Math.min(jumps[j]+1, jumps[i]);
					break;
				}
			}
		}
		return jumps[n-1];
		
	}
}
