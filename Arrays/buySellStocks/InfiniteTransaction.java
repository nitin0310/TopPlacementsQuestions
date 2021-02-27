package buySellStocks;

//sliding window variation	-variable size

public class InfiniteTransaction {
	public static void main(String args[]) {
		int[] stocks= {100,300,70,150,20,400};
		System.out.println(maxProfitWithInfiniteTrans(stocks,6));
		
	}

	static int maxProfitWithInfiniteTrans(int[] stocks,int n) {
		
		int buyIndex=0;
		int sellIndex=0;
		int profit=0;
		
		for(int i=1;i<n;i++) {
			if(stocks[i]<stocks[sellIndex]) {
				profit+=stocks[sellIndex]-stocks[buyIndex];
				buyIndex=i;
				sellIndex=i;
				
			}else {
				sellIndex=i;
			}
		}
		
		//at last if there exists no downStock, then sell last buyed stock
		profit+=stocks[sellIndex]-stocks[buyIndex];
		
		return profit;
	}
	
	/*
	 no restriction for buying and selling stocks,
	 one thing we need to take care about is --
	 
	 only BSBS is possible , Buy Sell Buy Sell
	 so BBSS SSBB SBSB is not possible
	 
	 now from graph we can analyze, at every downStock we never get profit
	 and when there exists a downStock then calculate profit and sum it to profit,then update buyIndex and sellIndex,
	 buy that downStock,and temporarily sellIndex to that as well
	 */
}