package binarySearch;

public class MainClass {
	//O(logn) time				O(1) space
	//but as it is providing search in less time, then it must require sorted array
	public static void main(String args[]) {
		int[] array= {1,6,9,14,23,26};
		search(array,0,5,1);
	}
	
	//must have sorted array
	static void search(int array[],int lb,int ub,int key) {
		if(lb<ub) {
			int mid=(ub-lb)/2;
			
			if(array[mid]==key) {
				System.out.println("found at "+mid+" index");
				return;
			}
			
			if(key<array[mid]) {
				search(array,lb,mid-1,key);
			}else {
				search(array,mid+1,ub,key);
			}
		}
	}
}
