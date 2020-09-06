package question_36;
import java.io.*;

public class UsingLoops {//---O(n*m)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		
		int values[]=new int[m*n];
		for(int i=0;i<(m*n);i++)
			values[i]=Integer.parseInt(str[i]);
		
		int array[]=new int[m];
		
		System.out.println(findRow(values,array,m,n));
	}
	
	static int findRow(int values[],int array[],int row,int col) {
		
		int count=0,j=0;
		
		for(int i=0;i<=row*col;i++) {
			if(i==0) {
				if(values[i]==1) {
					count++;
				}
			}else if(i==row*col) {
				array[j]=count;
			}else {
				if(i%col!=0) {
					if(values[i]==1) {
						count++;
					}
				}else {
					array[j]=count;
					count=0;
					j++;
					if(values[i]==1) {
						count++;
					}
				}
			}
		}
		
		int maxIndex=0;
		int maxValue=array[0];
		
		for(int i=0;i<row;i++) {
			if(maxValue<array[i]) {
				maxValue=array[i];
				maxIndex=i;
			}
		}
		return maxIndex;
		
	}
	
	
}
