package question12;

public class MainClass {
	public static void main(String args[]) {
		int[] input= {1,2,3};
		int n=3;
		int r=2;
		int[] output= new int[r];		
		printAllComb(input,output,0,n-1,0,r);
	}
	
	static void printAllComb(int[] array,int[] output,int start,int end,int index,int r) {
		
		if(index==r) {//when it reaches it's size then print and return
			for(int j=0;j<r;j++) {
				System.out.print(output[j]);
			}
			System.out.println();
			return;//important to remember
		}
		
		for(int i=start;i<=end;i++) {
			output[index]=array[i];//fixing value
			printAllComb(array,output,i+1,end,index+1,r);
			//updating value of start and index,end always be same bcz in patter we need to reach till last every time
		}
	}
}
