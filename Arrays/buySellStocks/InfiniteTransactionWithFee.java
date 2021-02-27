package buySellStocks;

/*
 BSP - Buying State Profit, is state me ek stock ko hmesha kharid k rakhenge
 SSP - Selling State Profit, is state me koi stock nhi rakhenge
 
 when we sell a buyed stock, then it take a fee, so while selling we need to deduct as well
 
 */
public class InfiniteTransactionWithFee {
	public static void main(String args[]) {
		int stocks[]= {10,20,30};
		int n=3;
		int fee=2;
		
		System.out.println(maxProfitWithFee(stocks,n,fee));
	}
	
	static int maxProfitWithFee(int[] stocks,int n,int fee) {
		
		int oldBSP=-stocks[0];								//first stock ko kharid hi liya loan pe
		int oldSSP=0;										//pehle din sell state me nhi aa skte to, 0 state me rhenge
		
		for(int i=1;i<n;i++) {
			
			int newBSP=0;									//jo ab stock aaya hai, wo karidte hai to
			int newSSP=0;									//jo ab aaya stock, bechte hai to
			
			
			if(oldSSP-stocks[i]>oldBSP) {					//current me abhi koi stock nhi kharida hua hai, agar hum current ko kharidte hai to, zyada loan kisme lgega current ko kharidne me ya pichla kharida hua hai but becha nhi
				newBSP=oldSSP-stocks[i];
			}else {
				newBSP=oldBSP;
			}
			
			//why add?										 bcz oldBSP already -ve hai, humne initially loan pe kharida tha pehla stock
			if(oldBSP+stocks[i]-fee>oldSSP) {				//last jo koi bhi humne kharida tha, agar use current pe bechte hai to,kya pocket me bache paise badh jayenge ya nuksan hoga
				newSSP=oldBSP+stocks[i]-fee;
			}else {											//nuksan hai to hum is pe bech hi nhi rhe
				newSSP=oldSSP;
			}
			
			//finally balance update kr do
			oldBSP=newBSP;
			oldSSP=newSSP;
		}
		
		return oldSSP;
	}
}
