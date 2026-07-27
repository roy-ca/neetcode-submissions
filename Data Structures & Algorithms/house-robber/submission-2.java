class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       int[] dp = new int[n + 1];
       Arrays.fill(dp, -1);
       return maxMoney(n - 1, nums, dp);
    }

    private int maxMoney(int n, int[] nums, int[] dp) {
        if(n == 0) {
            return nums[0];
        }

        if(n < 0) {
            return 0;
        }

        if(dp[n] != -1) {
            return dp[n];
        }


        //Use the logic for seqeuence
        int rob = nums[n] + maxMoney(n - 2, nums, dp);
        int notRob = maxMoney(n - 1, nums, dp);

        return dp[n] = Math.max(rob, notRob);
    }
}
