class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(
            robHelper(nums, 0, n-1),
            robHelper(nums, 1, n)
        );
    }

    public int robHelper(int[] nums, int start, int end) {
        int a = 0;
        int b = 0;
        for (int i=start; i<end; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
