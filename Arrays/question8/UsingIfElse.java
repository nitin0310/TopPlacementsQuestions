package question8;

import java.io.*;

public class UsingIfElse {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int z=0,o=0,t=0;
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(br.readLine());
			if(value==0) {
				z++;
			}else if(value==1) {
				o++;
			}else {
				t++;
			}
		}
		
		for(int i=0;i<z;i++)
			System.out.print(0+" ");
		for(int i=0;i<o;i++)
			System.out.print(1+" ");
		for(int i=0;i<t;i++)
			System.out.print(2+" ");
	}
}
