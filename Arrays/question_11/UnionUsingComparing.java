package question_11;
import java.io.*;
import java.util.Arrays;

public class UnionUsingComparing {				//O(nm)

	public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int testCase=Integer.parseInt(br.readLine());
	
	while(testCase>0) {
		int array1len=Integer.parseInt(br.readLine());
		int array2len=Integer.parseInt(br.readLine());
		int array1[]=new int[array1len];
		int array2[]=new int[array2len];
		
		
		for(int i=0;i<array1len;i++) {
			array1[i]=Integer.parseInt(br.readLine());
		}
		for(int i=0;i<array2len;i++) {
			array2[i]=Integer.parseInt(br.readLine());
		}
		int union=0;
		
			for(int i=0;i<array2len;i++) {
				int value=array2[i];
				boolean found=false;
				for(int j=0;j<array1len;j++) {
					if(value==array1[j]) {
						found=true;
					}
				}
				if(found==false) {
				union++;
				}
			}
		union=union+array1len;
		
//			======merge sort and binary search O(nlogM + mlogn) ====
		
//			if(array1len<array2len) {
//				Arrays.sort(array2);
//				for(int i=0;i<array1len;i++) {
//					boolean found=false;
//					if(Arrays.binarySearch(array2, array1[i])!=-1) {
//						found=true;
//					}
//					
//					if(found==false) {
//						System.out.println("called");
//						union++;
//					}
//				}
//				
//				union=union+array2len;
//			}else {
//				Arrays.sort(array1);
//				for(int i=0;i<array2len;i++) {
//					boolean found=false;
//					if(Arrays.binarySearch(array1, array2[i])!=-1) {
//						found=true;
//					}
//					
//					if(found==false) {
//						union++;
//					}
//				}
//				
//				union=union+array1len;
//			}
			System.out.println("Union : "+union);
		
		
		testCase--;
	}
	
	}

}
