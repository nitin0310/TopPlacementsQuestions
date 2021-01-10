package linearSearch;

public class MainClass {
	//O(n) time					O(1) space
	public static void main(String args[]) {
		int[] array= {5,2,7,9,2};
		search(array,5,9);
	}
	
	static void search(int[] array,int n,int key) {
		for(int i=0;i<n;i++) {
			if(array[i]==key) {
				System.out.println("found at "+i+" index");
				return;
			}
		}
		
		System.out.println("Not found");
	}
}
