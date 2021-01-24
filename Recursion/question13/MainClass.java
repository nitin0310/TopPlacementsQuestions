package question13;

public class MainClass {
	public static void main(String args[]) {
		int n=3;
		int array[]=new int[n];
		for(int i=0;i<n;i++)
			array[i]=i+1;
		int k=2;
		int output[]=new int[k];
		findSequencies(array,output,0,n-1,0,k);
	}
	
	static void findSequencies(int[] array,int[] output,int start,int end,int index,int k) {
		
		
		if(index==k) {
			for(int j=0;j<k;j++) {
				System.out.print(output[j]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=end;i++) {
			output[index]=array[i];
			findSequencies(array,output,i+1,end,index+1,k);
		}
	}
}
