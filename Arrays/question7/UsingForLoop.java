package question7;
import java.io.*;

public class UsingForLoop {
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int length=Integer.parseInt(br.readLine());
		int array[]=new int[length];
		int frequency=0;
		
		for(int i=0;i<length;i++) {
			array[i]=Integer.parseInt(br.readLine());
			if(array[i]==n) {
				frequency++;
			}
		}
		
		System.out.println(frequency);
		
	}
}
