package quickSort;

public class MainClass {
	public static void main(String args[]) {
		int[] array= {1,4,2,6,3};
		print(array,array.length);
		sort(array,0,array.length-1);
		print(array,array.length);
	}
	
	static void sort(int[] array,int lb,int ub) {
		if(lb<ub) {
			int index=partition(array,lb,ub);
			sort(array,lb,index-1);//call for left array
			sort(array,index+1,ub);//call for right array
		}
	}
	
	static int partition(int[] array,int lb,int ub) {
		
		int pivot=array[ub];//put last item as pivot
		int partitionIndex=lb;
		
		for(int i=lb;i<=ub-1;i++) {//traverse from lb to ub-1 and set smaller to left and greater to right
			if(array[i]<pivot) {
				swap(array,i,partitionIndex);//if less then traverse to itself
				partitionIndex++;//increase index,bcz if the number is greater then it get shifted to right
			}
		}
		
		swap(array,partitionIndex,ub);
		return partitionIndex;
	}
	
	static void swap(int[] array,int a,int b) {
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	static void print(int[] array,int n) {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
