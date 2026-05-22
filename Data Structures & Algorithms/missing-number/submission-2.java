class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int e: nums) {
            res ^= e;
        }
        for (int i=1; i<=nums.length; i++) {
            res ^= i;
        }
        return res;
    }
}
