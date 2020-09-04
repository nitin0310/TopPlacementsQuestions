package question1;
import java.io.*;

public class MainClass {
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int array[]=new int[10];
		
		System.out.println("Enter 10 elements : ");
		for(int index=0;index<10;index++) {
			array[index]=Integer.parseInt(br.readLine());
		}
		
		System.out.println("Entered array : ");
		for(int value:array) {
			System.out.print(value+" ");
		}
		
	}
}
