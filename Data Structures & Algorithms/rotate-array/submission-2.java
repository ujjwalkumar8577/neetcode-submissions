class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);    // Step 1: Reverse entire array
        reverse(nums, 0, k - 1);    // Step 2: Reverse first k elements
        reverse(nums, k, n - 1);    // Step 3: Reverse rest
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}