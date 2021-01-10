package bubbleSort;

public class MainClass {
	//O(n^2) time			O(1) space
	public static void main(String args[]) {
		int array[]= {1,4,2,6,3};
		printArray(array,array.length);
		sort(array,array.length);
		printArray(array,array.length);
	}
	
	//comparing algorithm
	static void sort(int array[],int n) {
		
		for(int i=0;i<n-1;i++) {//for n-1 passes
			for(int j=0;j<n-1;j++) {//bcz we are comparing j with j+1,so at last we need to reach n-2 only
				if(array[j+1]<array[j]) {
					swap(array,j,j+1);
				}
			}
		}
		
	}
	
	static void swap(int[] array,int a,int b) {
		int temp=array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	static void printArray(int[] array,int n) {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
