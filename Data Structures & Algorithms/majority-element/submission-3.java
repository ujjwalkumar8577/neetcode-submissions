class Solution {
    public int majorityElement(int[] nums) {
        int tmp = nums[0];
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == tmp) {
                count++;
            } else {
                count--;
            }           
            if (count < 0) {
                tmp = nums[i];
            } 
        }
        return tmp;
    }
}