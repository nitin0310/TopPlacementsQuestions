package question8;
import java.io.*;
import java.util.*;

public class UsingHashMap {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int value=Integer.parseInt(br.readLine());
			if(hmap.containsKey(value)) {
				hmap.put(value, hmap.get(value)+1);
			}
			else {
				hmap.put(value, 1);
			}
		}
		for(int i=0;i<3;i++) {
			int frequency=hmap.get(i);
			for(int j=0;j<frequency;j++) {
				System.out.print(i+" ");
			}
		}
		
	}

}
