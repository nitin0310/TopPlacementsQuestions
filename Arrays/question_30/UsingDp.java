package question_30;
import java.io.*;

public class UsingDp {		//O(n)
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int prices[]=new int[n];
		String str[]=br.readLine().trim().split(" ");
		for(int i=0;i<n;i++) {
			prices[i]=Integer.parseInt(str[i]);
		}
		
		System.out.println("Maximuum profit : "+findMaximumProfit(prices,n));
	}
	
	static int findMaximumProfit(int prices[],int n) {
		int profit[]=new int[n];
		
		for(int i=0;i<n;i++)
			profit[i]=0;
		
		//for 1 transactions
		int max_price=prices[n-1];
		for(int i=n-2;i>=0;i--) {//--------- one transaction
			
			if(prices[i] > max_price) {
				max_price=prices[i];
			}
				
			//else nhi hai ye
			//kharid to skte hai
			profit[i]=Math.max(max_price-prices[i], profit[i+1]);
			//kharid liya , nhi kharida ------me se maximum
			
		}
		
		//for 2 transactions
		int min_price=prices[0];
		for(int i=1;i<n;i++) {
			if(prices[i]<min_price) {
				min_price=prices[i];
			}
				
			//else nhi hai ye
			profit[i]=Math.max((prices[i]-min_price)+profit[i], profit[i-1]);
			
		}
		return profit[n-1];
	}
}
