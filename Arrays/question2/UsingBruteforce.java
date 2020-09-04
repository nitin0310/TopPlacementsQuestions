package question2;
import java.io.*;;

public class UsingBruteforce {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int array[]=new int[m];
		for(int i=0;i<m;i++) {
			array[i]=Integer.parseInt(br.readLine());
		}
		System.out.println("present? "+checkNumber(array,n));
		

	}
	
	static boolean checkNumber(int array[],int key) {
		for(int value:array) {
			if(value==key) {
				return true;
			}
		}
		return false;
	}

}
