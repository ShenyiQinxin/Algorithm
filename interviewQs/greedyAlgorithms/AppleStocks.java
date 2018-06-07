import static java.util.Math.max;

public AppleStocks{
	public static int getMaxProfit(int[] stockPrices){
		if(stockPrices.length<2){
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}
		int minPrice = stockPrices[0];
		int maxProfit = stockPrices[1] - stockPrices[0];
		
		for(int i=1; i< stockPrices.length; i++){
			int currentPrice = stockPrices[i];
			int potentialProfit = currentPrice - minPrice;
			maxProfit = max(maxProfit, potentialProfit);
			minPrice = min(minPrice, currentPrice);
			
		}
		return maxProfit;
	}//end method
}