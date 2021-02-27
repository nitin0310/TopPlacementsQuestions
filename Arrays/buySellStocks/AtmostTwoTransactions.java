package buySellStocks;
import java.util.Arrays;

//O(n) time		--DP
//O(n) space

public class AtmostTwoTransactions {
	public static void main(String args[]) {
		int[] stocks= {10,20,5,30};
		int n=4;
		
		System.out.println(maxProfitWithAtmost2Trans(stocks,n));
	}
	
	static int maxProfitWithAtmost2Trans(int[] stocks,int n) {
		
		//-------------- hum km se km me kharidenge and jitna profit ho skega wahan tk,agar hme usi din sell krna pde stock to, wo store kr lenge
		int profitIfSellToday[]=new int[n];
		Arrays.fill(profitIfSellToday, Integer.MIN_VALUE);
		profitIfSellToday[0]=0;
		
		int least=stocks[0];
		for(int i=1;i<n;i++) {
			if(stocks[i]<least) {
				least=stocks[i];
			}
			
			profitIfSellToday[i]=Math.max(profitIfSellToday[i-1], stocks[i]-least);
		}
		
		
		//-------------- ye hum reverse me krenge, ki hum max me stock bech rhe hai, to hume ab minimum se minimum me buy krna hai, to ye maan lenge ki usi din buy kre to profit kitna bnega us transaction, wo store kr lo
		int profitIfBuyToday[]=new int[n];
		Arrays.fill(profitIfBuyToday, Integer.MIN_VALUE);
		profitIfBuyToday[n-1]=0;
		
		int max=stocks[n-1];
		for(int i=n-2;i>=0;i--) {
			if(stocks[i]>max) {
				max=stocks[i];
			}
			
			profitIfBuyToday[i]=Math.max(profitIfBuyToday[i+1], max-stocks[i]);
		}
		
		
		//---------------now humare pass dono profit hai, ki agar hum buy kre fir sell kre to wahan tk max profit, fir buy kre or sell kre to max profit, to dono ka sum total profit hoga
		int finalMaxProfit[]=new int[n];
		
		for(int i=0;i<n;i++) {
			finalMaxProfit[i]=profitIfBuyToday[i]+profitIfSellToday[i];
		}
		
		//at last jis transaction me zyada profit hai wo return kro
		int maxProfit=finalMaxProfit[0];
		for(int i=0;i<n;i++) {
			maxProfit=Math.max(maxProfit, finalMaxProfit[i]);
		}
		
		return maxProfit;
	}
}
