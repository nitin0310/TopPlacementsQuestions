package question_31;
import java.io.*;

public class UsingLoopsButSorted {

	public static void main(String[] args) throws IOException{
		// When array is already in sorted order
		//----------- O(n)
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		
		int heights[]=new int[n];
		
		String str[]=br.readLine().trim().split(" ");
		for(int i=0;i<n;i++)
			heights[i]=Integer.parseInt(str[i]);
		
		System.out.println(minimiseMaximumDifference(heights,k,n));
	}
	
	static int minimiseMaximumDifference(int heights[],int k,int n) {
		int min_height=heights[0];
		
		for(int i=0;i<n;i++) {
			if(heights[i]>min_height)
				heights[i]=heights[i]-k;
			else
				heights[i]=heights[i]+k;
		}
		
		int min=heights[0];
		int max=heights[0];
		
		//jab hum update kr denge to ho skta hai ki next values previous se small ho jaye
		for(int i=0;i<n;i++) {
			if(heights[i]<min)
				min=heights[i];
			if(heights[i]>max)
				max=heights[i];
		}
		
		return max-min;
	}

}
