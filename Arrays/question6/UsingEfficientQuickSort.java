package question6;

import java.io.*;

public class UsingEfficientQuickSort {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int k=Integer.parseInt(br.readLine());
		int totalElements=Integer.parseInt(br.readLine());
		
		int array[]=new int[totalElements];
		for(int index=0;index<totalElements;index++) {
			array[index]=Integer.parseInt(br.readLine());
		}
		
		System.out.println("Kth Smallest no. "+quickSort(array,0,totalElements-1,k));
	}
	
	static void swap(int array[],int i,int j) {
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	static int partition(int array[],int lb,int ub) {
		int pivot=array[ub];
		int partitionIndex=lb;
		
		for(int j=lb;j<ub;j++) {
			if(array[j]<pivot) {
				swap(array,partitionIndex,j);
				partitionIndex++;
			}
		}
		
		swap(array,partitionIndex,ub);
		
		return partitionIndex;
	}
	
	static int quickSort(int array[],int lb,int ub,int k) {
//		if(lb<ub) {
//			int index=partition(array,lb,ub);
//
//			quickSort(array,lb,index-1);
//			quickSort(array,index+1,ub);
//		}
		
		if(k>0 && k<=ub-lb+1) {
			int index=partition(array,lb,ub);
			
			if(index-lb==k-1) {
				return array[k];
			}
			
			if(index-lb<k-1) {
				return quickSort(array,index+1,ub,k-index+lb-1);
			}
			
			return quickSort(array,lb,index-1,k);
		}
		return Integer.MAX_VALUE;
	}
}
