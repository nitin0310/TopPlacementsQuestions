package question_39;
import java.io.*;
import java.util.*;

public class UsingHashMap {//	O(m) time, space O(n)
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int m=Integer.parseInt(br.readLine());
		int n=Integer.parseInt(br.readLine());
		String str1[]=br.readLine().trim().split(" ");
		String str2[]=br.readLine().trim().split(" ");
		
		int array1[]=new int[m];
		int array2[]=new int[n];
		
		for(int i=0;i<m;i++)
			array1[i]=Integer.parseInt(str1[i]);
		
		for(int j=0;j<n;j++)
			array2[j]=Integer.parseInt(str2[j]);

		if(m>n) {
			System.out.println("False");
		}else {
			System.out.println(checkSubset(array1,array2,m,n));
		}
	}
	
	static boolean checkSubset(int arr1[],int arr2[],int m,int n) {
		HashMap<Integer,Integer> hashMap=new HashMap<Integer,Integer>();
		
		for(int i=0;i<n;i++)
			hashMap.put(arr2[i], 0);
		
		for(int i=0;i<m;i++)
			if(hashMap.containsKey(arr1[i])) {
				hashMap.put(arr1[i], 1);
			}
		
		boolean flag=true;
		for(Map.Entry<Integer, Integer> e:hashMap.entrySet()) {
			if(e.getValue()!=1)
				flag=false;
		}
		return flag;
	}
}