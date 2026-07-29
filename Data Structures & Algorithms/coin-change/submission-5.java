class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
       
        for(int row[]: dp) {
            Arrays.fill(row, -1);
        }
        int count =  countCoin(n - 1, coins, amount, dp);
        return count == (int)1e9 ? -1 : count;
    }

    private int countCoin(int ind, int[] coins, int target, int[][] dp) {
        if(ind == 0) {
            if(target % coins[ind] == 0) {
                return target / coins[ind];
            }
            return (int)1e9;
        }

        if(dp[ind][target] != -1)
            return dp[ind][target];
        
        int notTake = 0 + countCoin(ind - 1, coins, target, dp);
        int take = (int)1e9;
        if(coins[ind] <= target) {
            int res = countCoin(ind, coins, target - coins[ind], dp);
            if(res != (int)1e9)
                take = 1 + res;
        }
        return dp[ind][target] = Math.min(take, notTake);
    }
}
