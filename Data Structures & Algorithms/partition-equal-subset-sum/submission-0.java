class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int e: nums) {
            sum += e;
        }
        if (sum % 2 != 0) {
            return false;
        }
        return targetSum(nums, 0, sum / 2);
    }

    public boolean targetSum(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }
        return targetSum(nums, i+1, sum - nums[i])
            || targetSum(nums, i+1, sum);
    }
}
