package question_16;
import java.io.*;
import java.util.*;

public class QuickSortAlgorithm {			//O(n logn)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int array[]=new int[n];
		
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		quickSort(array,0,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
	}

	
	static int partition(int array[],int lb,int ub) {
		int pivot=array[ub];
		int PartitionIndex=lb;
		
		for(int i=lb;i<=ub;i++) {
			if(array[i]<pivot) {
				swap(array,i,PartitionIndex);
				PartitionIndex++;
			}
		}
		
		swap(array,PartitionIndex,ub);
		return PartitionIndex;
	}
	
	static void quickSort(int array[],int lb,int ub) {
		if(lb<ub) {
			int index=partition(array,0,ub);
			quickSort(array,0,index-1);
			quickSort(array,index+1,ub);
		}
	}
	
	static void swap(int array[],int a,int b) {
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}

}
