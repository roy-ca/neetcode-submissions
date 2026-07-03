class Solution {
    public int maxProfit(int[] prices) {
       //Fits into sliding window as left side moves only when finding cheaper price and right pointer moves continously

       int minimumPrice = prices[0];
       int maxProfit = 0;

       for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minimumPrice) {
                minimumPrice = prices[i];
            }

            int profit = prices[i] - minimumPrice;
            if(profit > maxProfit) {
                maxProfit = profit;
            }
       }
       return maxProfit;
    }
}
