class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int ind = n-1;
        for (int i=n-2; i>= 0; i--) {
            if (i + nums[i] >= ind) {
                ind = i;
            }
        }
        return ind == 0;
    }
}
