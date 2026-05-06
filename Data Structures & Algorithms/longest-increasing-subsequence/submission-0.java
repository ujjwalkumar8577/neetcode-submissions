class Solution {
    public int lengthOfLIS(int[] nums) {
        return calculate(nums, 0, -1000000);
    }

    public int calculate(int[] nums, int i, int last) {
        if (i >= nums.length) {
            return 0;
        }
        if (nums[i] <= last) {
            return calculate(nums, i+1, last);
        }
        return Math.max(
            1 + calculate(nums, i+1, nums[i]),
            calculate(nums, i+1, last)
        );
    }
}
