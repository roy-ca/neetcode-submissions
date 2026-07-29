class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
       
    //     for(int row[]: dp) {
    //         Arrays.fill(row, -1);
    //     }
    //     int count =  countCoin(n - 1, coins, amount, dp);
    //     return count == (int)1e9 ? -1 : count;

        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            }
            else {
                dp[0][i] = (int)1e9;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= amount; j++) {
                int notTake = 0 + dp[i - 1][j];
                int take = (int)1e9;
                if(coins[i] <= j) {
                    int res = dp[i][j - coins[i]];
                    if(res != (int)1e9)
                        take = 1 + res;
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return ans >= (int)1e9 ? -1 : ans;
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
