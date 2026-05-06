class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSumHelper(nums, 0, 0);
    }

    public int subsetXORSumHelper(int[] nums, int i, int tmp) {
        if (i >= nums.length) {
            return tmp;
        }
        return subsetXORSumHelper(nums, i+1, tmp^nums[i])
            + subsetXORSumHelper(nums, i+1, tmp);
    }
}