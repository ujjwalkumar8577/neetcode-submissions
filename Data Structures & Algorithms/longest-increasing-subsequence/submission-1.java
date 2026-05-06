class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][2002];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return calculate(nums, 0, -1001);
    }

    public int calculate(int[] nums, int i, int last) {
        if (i >= nums.length) {
            return 0;
        }
        int key = last+1001;
        if (dp[i][key] != -1) {
            return dp[i][key];
        }
        if (nums[i] <= last) {
            return dp[i][key] = calculate(nums, i+1, last);
        }
        return dp[i][key] = Math.max(
            1 + calculate(nums, i+1, nums[i]),
            calculate(nums, i+1, last)
        );
    }
}
