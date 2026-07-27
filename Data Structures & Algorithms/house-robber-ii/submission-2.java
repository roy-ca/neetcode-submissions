class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }

        int[] nums1 = new int[n - 1];
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int c = 0;
        for(int i = 0; i < n; i++) {
            if(i != 0)
                nums1[c++] = nums[i];
        }

        c = 0;
        int[] nums2 = new int[n - 1];
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        for(int i = 0; i < n; i++) {
            if(i != n - 1)
                nums2[c++] = nums[i];
        }

        return Math.max(maxMoney(n - 2, nums1, dp1), maxMoney(n - 2, nums2, dp2));

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

        int rob = nums[n] + maxMoney(n - 2, nums, dp);
        int notRob = maxMoney(n - 1, nums, dp);

        return dp[n] = Math.max(rob, notRob);
    }
}
