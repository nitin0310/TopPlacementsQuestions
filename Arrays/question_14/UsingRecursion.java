package question_14;
import java.io.*;

public class UsingRecursion {			//O(n^2)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		int len=Integer.parseInt(br.readLine());
		int sum=Integer.parseInt(br.readLine());
		int array[]=new int[len];
		
		for(int i=0;i<len;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		int count=0;
		
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(array[i]+array[j]==sum) {
					count++;
				}
			}
		}
		System.out.println("count : "+count);
		
//		System.out.println("count we get : "+findCount(array,len,sum));
	}
	
	/**			=====================  O(2^n)  =======================
	  =========	this is for subset not pairs ---pairs can only be in two but subsets
	  can be more or less than 2 so, we don't use it here	=========================
	 
	 static int findCount(int array[],int n,int sum) {
		if(n==0 && sum>0)
			return 0;
		
		if(sum==0) {
			return 1;
		}
		
		else
			if(array[n-1]<=sum) {
				return findCount(array,n-1,sum-array[n-1])+findCount(array,n-1,sum);
			}else {
				return findCount(array,n-1,sum);
			}
	}
	
	 */
	

}
