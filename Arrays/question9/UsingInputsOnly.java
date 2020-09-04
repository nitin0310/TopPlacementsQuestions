package question9;
import java.io.*;

public class UsingInputsOnly {			//O(n)

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		int max=0,min=0;
		
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(br.readLine());
			if(i==0) {
				max=min=value;
			}else {
				if(value<min) {
					min=value;
				}
				if(value>max) {
					max=value;
				}
			}
		}
		
		System.out.println("range of array : "+(max-min));
	}

}
