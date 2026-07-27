class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n + 1];

       dp[0] = nums[0];
       for(int i = 1; i < n; i++) {
            int rob = nums[i];
            if(i > 1)
                rob += dp[i - 2];
            int notRob = dp[i - 1];

            dp[i] = Math.max(rob, notRob);
       }

       return dp[n - 1];
    //    Arrays.fill(dp, -1);
    //    return maxMoney(n - 1, nums, dp);
    }

    // private int maxMoney(int n, int[] nums, int[] dp) {
    //     if(n == 0) {
    //         return nums[0];
    //     }

    //     if(n < 0) {
    //         return 0;
    //     }

    //     if(dp[n] != -1) {
    //         return dp[n];
    //     }


    //     //Use the logic for seqeuence
    //     int rob = nums[n] + maxMoney(n - 2, nums, dp);
    //     int notRob = maxMoney(n - 1, nums, dp);

    //     return dp[n] = Math.max(rob, notRob);
    // }
}
