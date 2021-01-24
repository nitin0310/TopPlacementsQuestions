package question19;

public class MainClass {
	public static void main(String args[]) {
		int array[]= {12,11,13,5,6};
		print(array,array.length);
		insertionSort(array,array.length);
		print(array,array.length);
	}
	
	static void insertionSort(int[] array,int n) {
		if(n==0 || n==1) {//if there's a single element or no element then return,nothing in left to check with;
			return;
		}
		//this is the call for each element,bcz if we have greatest element in left most side,then we have to take
		//it it's correct position as well
		insertionSort(array,n-1);
		
		if(array[n-1]<array[n-2]) {//checking with left node
			swap(array,n-1,n-2);//if smaller then swap
			insertionSort(array,n-1);//now again check with next left node further via call
		}
		
		return;
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
