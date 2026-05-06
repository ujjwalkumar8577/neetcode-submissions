class Solution {
    Integer dp[][];
    int maxSum;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int e: nums) {
            sum += Math.abs(e);
        }
        maxSum = sum;
        dp = new Integer[nums.length][2 * sum + 1];
        return findTargetSumWaysHelper(nums, target, 0, 0);
    }

    public int findTargetSumWaysHelper(int[] nums, int target, int sum, int i) {
        if (i >= nums.length && target == sum) {
            return 1;
        }
        if (i >= nums.length) {
            return 0;
        }
        int sumIndex = sum + maxSum;
        if (dp[i][sumIndex] != null) {
            return dp[i][sumIndex];
        }
        return dp[i][sumIndex] = (findTargetSumWaysHelper(nums, target, sum + nums[i], i+1)
            + findTargetSumWaysHelper(nums, target, sum - nums[i], i+1));
    }
}
