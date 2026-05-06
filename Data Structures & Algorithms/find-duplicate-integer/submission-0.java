class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int tmp = nums[0];
        while (tmp != slow) {
            tmp = nums[tmp];
            slow = nums[slow];
        }
        return tmp;
    }
}
