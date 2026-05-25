class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // Remember this edge case
        if (n == 1) {
            return nums[0];
        }
        int dp1[] = new int[n + 1];
        int dp2[] = new int[n + 1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(
            robHelper(nums, dp1, 0, n-1),
            robHelper(nums, dp2, 1, n)
        );
    }

    public int robHelper(int[] nums, int[] dp, int i, int n) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int a = robHelper(nums, dp, i+1, n);
        int b = nums[i] + robHelper(nums, dp, i+2, n);
        return dp[i] = Math.max(a, b);
    }
}
