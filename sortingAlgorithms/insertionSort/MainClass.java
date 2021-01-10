package insertionSort;

public class MainClass {
	//O(n^2) time,but best at nearly sorted			O(1) space
	public static void main(String args[]) {
		int[] array= {1,4,2,6,3};
		print(array,array.length);
		sort(array,array.length);
		print(array,array.length);
	}
	
	//comparing algorithm
	static void sort(int[] array,int n) {
		
		for(int i=1;i<n;i++) {//for n-1 passes,and we need to compare to prev. element then start i=1
			int min=array[i];//hold ith value
			int j=i-1;//prev. always index starts from i-1
			while(j>=0 && min<array[j]) {
				array[j+1]=array[j];//if prev is smaller then shift that value to j+1,now we have same value at j and j+1 both
				j--;
			}
			//finally at any pos. when we leave while loop then we have 2 cont. pos. where same value is present,then add min at its pos.
			array[j+1]=min;
		}
	}
	
	static void print(int[] array,int n) {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
