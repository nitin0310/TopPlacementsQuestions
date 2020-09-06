package question_37;
import java.io.*;
import java.util.Arrays;

public class UsingSorting {//-----O(r logc) or O(c logr)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		String str[]=br.readLine().trim().split(" ");
		
		int values[]=new int[m*n];
		for(int i=0;i<(m*n);i++)
			values[i]=Integer.parseInt(str[i]);
		
		Arrays.sort(values);
		
		System.out.println("mid element : "+(values[((m*n)-1)/2]));
	}
}
