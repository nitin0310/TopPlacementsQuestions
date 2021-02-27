package buySellStocks;

//sliding window variation	-variable size

public class OneTransaction {
	public static void main(String args[]) {
		int[] stocks= {100, 180, 260, 310, 40, 535, 695};
		
		System.out.println(maxProfitWith1Trans(stocks,7));
		
	}
	
	static int maxProfitWith1Trans(int[] stocks,int n) {
		
		int leastPrice=Integer.MAX_VALUE;
		int profitIfSellToday=0;
		int maxProfit=0;
		
		for(int i=0;i<n;i++) {
			
			if(stocks[i]>leastPrice) {
				profitIfSellToday=stocks[i]-leastPrice;
				if(profitIfSellToday>maxProfit) {
					maxProfit=profitIfSellToday;
				}
				
			}else {
				leastPrice=stocks[i];
			}
			
		}
		
		
		return maxProfit;
	}
	
	
	/*
	 if single transaction,
	 then calculate profit for each upstock, and update profit if it is more than maxProfit
	 
	 if there exist a downstock then update leastPrice if it is less than leastPrice
	 */
}
