package question23;
import java.util.*;

public class Bruteforce {
	//pura ni kiya but ho jayega loop se
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter no. of sets : ");
		int num=scan.nextInt();
		int sets[]=new int[num*2];
		
		System.out.println("Enter "+num+" sets : ");
		for(int i=0;i<sets.length;i++) {
			sets[i]=scan.nextInt();
		}
		
		System.out.println("Set entered : ");
		for(int i=0;i<sets.length;i++) {
			System.out.print(sets[i]+" ");
		}
	}
	
	void findOverlapped(int sets[]) {
		
		int output[]=new int[sets.length];
		int index=0;
		
		
		for(int i=0;i<sets.length;i=i+4) {
			int leftSetBigValue=sets[i+1];
			if(i+2<sets.length) {
				
				int rightSetSmallValue=sets[i+2];
				int rightSetBigValue=sets[i+3];
				
				if(rightSetSmallValue<leftSetBigValue) {
					if(rightSetSmallValue<i) {
						output[index]=rightSetSmallValue;
					}else{
						output[index]=sets[i];
					}
					
					index++;
					
					if(rightSetBigValue<sets[i+1]) {
						output[index]=sets[i+1];
					}else{
						output[index]=rightSetBigValue;
					}
				}
				
			}
		}
		
	}

}
