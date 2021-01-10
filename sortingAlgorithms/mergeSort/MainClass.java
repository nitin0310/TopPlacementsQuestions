package mergeSort;

public class MainClass {
	public static void main(String args[]) {
		int[] array= {1,4,2,6,3};
		print(array,array.length);
		mergeSort(array,0,array.length-1);
		print(array,array.length);
	}
	
	static void mergeSort(int[] array,int lb,int ub) {
		if(lb<ub) {//when we have more than one item then we can divide
			int mid=(ub+lb)/2;
			
			mergeSort(array,lb,mid);
			mergeSort(array,mid+1,ub);
			merge(array,lb,mid,mid+1,ub);
		}
	}
	
	static void merge(int[] array,int i1,int i2,int j1,int j2) {
		
		int i=i1;
		int j=j1;
		
		int output[]=new int[j2-i1+1];//imp--bcz j2-i1+1 gives size
		int k=0;
		
		while(i<=i2 && j<=j2) {//check till we reach end of one array
			if(array[i]<array[j]) {
				output[k]=array[i];
				i++;
			}else {
				output[k]=array[j];
				j++;
			}
			k++;
		}
		
		while(i<=i2) {//check if elements left in left array
			output[k]=array[i];
			i++;
			k++;
		}
		
		while(j<=j2) {//check if elements left in right array
			output[k]=array[j];
			j++;
			k++;
		}
		
		k=0;//here we need to add all values from output array,so from 0
		for(int index=i1;index<=j2;index++,k++) {//but the (starting index and array range) at array must be i1 to j2
			array[index]=output[k];
		}
	}
	
	static void print(int[] array,int n) {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
