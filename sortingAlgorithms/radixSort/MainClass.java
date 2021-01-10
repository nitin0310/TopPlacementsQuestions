package radixSort;

public class MainClass {
	public static void main(String args[]) {
		int array[]= {11,42,12,60,5};
		print(array,array.length);
		radixSort(array,array.length);
		print(array,array.length);
	}
	
	static void radixSort(int array[],int n) {
		int max=array[0];
		
		//getting max element
		for(int i=1;i<n;i++) {
			if(max<array[i]) {
				max=array[i];
			}
		}
		
		//running loop according to no. of digits in max elements
		for(int i=1;max/i>0;i*=10) {
			countSort(array,i);
		}
	}
	
	static void countSort(int array[],int exp) {
		int max=(array[0]/exp)%10;
		int output[]=new int[array.length];
		
		//getting maximum element
		for(int i=0;i<array.length;i++) {
			if(max<(array[i]/exp)%10) {
				max=(array[i]/exp)%10;
			}
		}
		
		int freq[]=new int[max+1];
		
		//setting 0 to all values
		for(int i=0;i<=max;i++) {
			freq[i]=0;
		}
		
		//updating all frequencies
		for(int i=0;i<array.length;i++) {
			freq[(array[i]/exp)%10]=freq[(array[i]/exp)%10]+1;
		}
		
		//adding prev. frequency, usually indicates indexes
		for(int i=0;i<max;i++) {
			freq[i+1]+=freq[i];
		}
		
		//inserting value to its correct location/index using freq[]
		for(int i=array.length-1;i>=0;i--) {
			//reverse bcz as further in radix sort,we have nearby preceding values--11,12,13
			//so in 1st phase they are sorted by 1,2,3 but in 2nd phase when we make use of freq[]
			//then we get right most side index of that value,and put most sorted to last right most index of that category
			output[freq[(array[i]/exp)%10]-1]=array[i];
			freq[(array[i]/exp)%10]=freq[(array[i]/exp)%10]-1;
		}
		
		//finally updating all values from output[] to array[]
		for(int i=0;i<array.length;i++) {
			array[i]=output[i];
		}
	}
	
	static void print(int array[],int n) {
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}
