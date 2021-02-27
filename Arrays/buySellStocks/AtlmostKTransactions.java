package buySellStocks;

public class AtlmostKTransactions {

	public static void main(String[] args) {
		int[] stocks= {10,20,30};
		int n=3;
		int k=1;

		System.out.println(maxProfitWithKTransactions(stocks,n,k));
		System.out.println(maxProfitWithKTransactionsOptimized(stocks,n,k));
	}
	
	
	static int maxProfitWithKTransactions(int[] stocks,int n,int k) {
		
		int[][] storeMaxProfit=new int[k+1][n];
		
		for(int i=0;i<n;i++) storeMaxProfit[0][i]=0;
		
		for(int i=0;i<k;i++) storeMaxProfit[i][0]=0;
		
		
		for(int trans=1;trans<=k;trans++) {
			for(int day=1;day<n;day++) {
				int max=storeMaxProfit[trans][day-1];
				
				for(int tranWithDay=0;tranWithDay<n;tranWithDay++) {			//ye bolta hai,ki ek transaction hum directly transWithDay k saath hi kr rhe hai, ab hmare pass k-1 trans bachi, jo ki already ho chuki hai transWithDay ki and stored hai , wo le lo stored me se
					int thatOneTrans = stocks[day]- stocks[tranWithDay];
					int remainKMinusOneTrans = storeMaxProfit[trans-1][tranWithDay];
				
					if(thatOneTrans + remainKMinusOneTrans > max) {				//it means this transaction made more profit, as compare to (if we don't do any transaction now, we just take prev)
						max = thatOneTrans + remainKMinusOneTrans;
					}
				}
				
				storeMaxProfit[trans][day]=max;
			}
		}
		
		
		return storeMaxProfit[k][n-1];
	}//O(n^3) time
	
	
	
	//optimized
static int maxProfitWithKTransactionsOptimized(int[] stocks,int n,int k) {
		
		int[][] storeMaxProfit=new int[k+1][n];
		
		for(int i=0;i<n;i++) storeMaxProfit[0][i]=0;
		
		for(int i=0;i<k;i++) storeMaxProfit[i][0]=0;
		
		
		for(int trans=1;trans<=k;trans++) {
			int max=Integer.MIN_VALUE;
			
			for(int day=1;day<n;day++) {
				if(storeMaxProfit[trans-1][day-1] - stocks[day-1] > max) {				//pehle hum,sbhi ka ye hrr baar find kr k indvidual le re the,ab jo max hoga wo le lete hai, fir 1 trans and 1 stock bachega agar ab bechte hai bache stock ko or wo already stored se zyada hai to update kr do
					max=storeMaxProfit[trans-1][day-1] - stocks[day-1];
				}
				
				if(max+stocks[day] > storeMaxProfit[trans][day-1]) {					//agar is bache stock ko ab bech de to zyada profit hai ya (na beche to, jo ki hume pichle se mil jayega barabar transactions but stock kmm,kyunki  use nhi bech rhe hum)
					storeMaxProfit[trans][day]=max+stocks[day];
				}else {
					storeMaxProfit[trans][day]=storeMaxProfit[trans][day-1];
				}
				
			}
		}
		
		
		return storeMaxProfit[k][n-1];
	}

}
