class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        int product = 1;
        for (int e: nums) {
            if (e == 0) {
                count++;
            } else {
                product *= e;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (count > 1) {
                nums[i] = 0;
            } else if (count == 1 && nums[i] == 0) {
                nums[i] = product;
            } else if (count == 1 && nums[i] != 0) {
                nums[i] = 0;
            } else {
                nums[i] = product/nums[i];
            }
        }
        return nums;
    }
}  
