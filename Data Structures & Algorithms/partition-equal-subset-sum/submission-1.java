class Solution {
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int e: nums) {
            sum += e;
        }
        if (sum % 2 != 0) {
            return false;
        }
        dp = new Boolean[nums.length][sum+1];
        return targetSum(nums, 0, sum / 2);
    }

    public boolean targetSum(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0) {
            return false;
        }
        if (i >= nums.length) {
            return false;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        return dp[i][sum] = (targetSum(nums, i+1, sum - nums[i]) || targetSum(nums, i+1, sum));
    }
}
