class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int dp1[] = new int[n];
        Arrays.fill(dp1, -1);
        int dp2[] = new int[n];
        Arrays.fill(dp2, -1);
        return Math.max(
            robHelper(nums, 0, n-1, dp1),
            robHelper(nums, 1, n, dp2)
        );
    }

    public int robHelper(int[] nums, int i, int n, int[] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        return dp[i] = Math.max(
            robHelper(nums, i+1, n, dp),
            nums[i] + robHelper(nums, i+2, n, dp)
        );  
    }
}
