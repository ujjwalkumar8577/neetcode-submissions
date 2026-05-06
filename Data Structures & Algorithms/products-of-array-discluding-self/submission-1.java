class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count0 = 0;
        int product = 1;
        for (int e: nums) {
            if (e != 0) {
                product *= e;
            } else {
                count0++;
            }
        }
        int res[] = new int[nums.length];
        if (count0 > 1) {
            return res;
        }
        for (int i=0; i<nums.length; i++) {
            res[i] = product;
            if (nums[i] != 0) {
                res[i] = (count0 == 0) ? product/nums[i] : 0;
            }
        }
        return res;
    }
}  
