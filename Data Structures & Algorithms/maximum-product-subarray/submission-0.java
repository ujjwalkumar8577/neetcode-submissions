class Solution {
    int ans;
    public int maxProduct(int[] nums) {
        ans = nums[0];
        helper(nums, 1, nums[0], nums[0]);
        return ans;
    }

    private void helper(int[] nums, int i, int curMin, int curMax) {
        if (i == nums.length) {
            return;
        }
        int n = nums[i];
        int nextMax = Math.max(n, Math.max(n * curMax, n * curMin));
        int nextMin = Math.min(n, Math.min(n * curMax, n * curMin));
        ans = Math.max(ans, nextMax);
        helper(nums, i + 1, nextMin, nextMax);
    }
}
