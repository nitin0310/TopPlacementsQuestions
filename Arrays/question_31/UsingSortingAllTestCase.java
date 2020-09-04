package question_31;
import java.io.*;
import java.util.Arrays;

public class UsingSortingAllTestCase {
	
	//O(n logn)
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		
		int heights[]=new int[n];
		
		String str[]=br.readLine().trim().split(" ");
		for(int i=0;i<n;i++)
			heights[i]=Integer.parseInt(str[i]);
		
		System.out.println(findMinimumDifference(heights,k,n));

	}
	
	static int findMinimumDifference(int heights[],int k,int n) {
		if(n==0 || n==1)
			return 0;
		
		Arrays.sort(heights);
		
		int ans=heights[n-1]-heights[0];
		
		int max=heights[n-1]-k;
		int min=heights[0]+k;
		
		for(int i=1;i<n-1;i++) {
			int newMin=heights[i]-k;
			int newMax=heights[i]+k;
			
			if(newMin>=min || newMax<=max)
				continue;
			
			if(max-newMin <= newMax-min) {
				min=newMin;
			}else {
				max=newMax;
			}
			
		}
		return Math.min(ans, max-min);
		
	}
}
