class Solution {
    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return robHelper(nums, 0);
    }

    public int robHelper(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int a = robHelper(nums, i+1);
        int b = nums[i] + robHelper(nums, i+2);
        return dp[i] = Math.max(a, b);
    }
}
