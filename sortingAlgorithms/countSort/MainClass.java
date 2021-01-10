 package countSort;

public class MainClass {
	//O(n+k) time		O(k) space
	//n-- no. of elements in main array
	//k-- the range of input(max element)
	public static void main(String args[]) {
		int[] array= {1,4,2,6,3};
		print(array,array.length);
		sort(array,array.length);
		print(array,array.length);
	}
	
	static void sort(int[] array,int n) {
		int max=array[0];
		int output[]=new int[n];
		
		//getting maximum element
		for(int i=0;i<n;i++) {
			if(max<array[i]) {
				max=array[i];
			}
		}
		
		int freq[]=new int[max+1];
		
		//setting 0 to all values
		for(int i=0;i<=max;i++) {
			freq[i]=0;
		}
		
		//updating all frequencies
		for(int i=0;i<n;i++) {
			freq[array[i]]=freq[array[i]]+1;
		}
		
		//adding prev. frequency, usually indicates indexes
		for(int i=0;i<max;i++) {
			freq[i+1]+=freq[i];
		}
		
		//inserting value to its correct location/index using freq[]
		for(int i=n-1;i>=0;i--) {
			//reverse bcz as further in radix sort,we have nearby preceding values--11,12,13
			//so in 1st phase they are sorted by 1,2,3 but in 2nd phase when we make use of freq[]
			//then we get right most side index of that value,and put most sorted to last right most index of that category
			output[freq[array[i]]-1]=array[i];
			freq[array[i]]=freq[array[i]]-1;
		}
		
		//finally updating all values from output[] to array[]
		for(int i=0;i<n;i++) {
			array[i]=output[i];
		}
	}
	
	static void print(int[] array,int n) {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
