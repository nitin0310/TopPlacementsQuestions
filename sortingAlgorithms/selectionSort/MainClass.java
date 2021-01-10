package selectionSort;

public class MainClass {
	public static void main(String args[]) {
		int[] array= {1,4,2,6,3};
		print(array,array.length);
		sort(array,array.length);
		print(array,array.length);
	}
	
	//comparing algorithm
	static void sort(int[] array,int n) {
		
		for(int i=0;i<n-1;i++) {//<n-1 bcz when we reach last we must have an element after that
			int min=i;//assuming this as minimum
			for(int j=i+1;j<n;j++) {
				if(array[j]<array[min]) {//if any element further is less than a[min] then that would be our min
					min=j;
				}
			}
			//finally swap with min
			swap(array,min,i);
		}
	}
	
	static void print(int[] array,int n) {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	static void swap(int[] array,int a,int b) {
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
}
