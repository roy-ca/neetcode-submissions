class Solution {
    public int maxProfit(int[] prices) {
       //Fits into sliding window as left side moves only when finding cheaper price and right pointer moves continously
        int maxProfit = 0;
        int minPrice = prices[0];

        int left = 0;

        for(int right = 1; right < prices.length; right++) {
            if(prices[right] < minPrice)
                minPrice = prices[right];

            int profit = prices[right] - minPrice;

            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}
