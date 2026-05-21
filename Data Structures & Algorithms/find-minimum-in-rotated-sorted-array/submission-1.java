class Solution {
    public int findMin(int[] nums) {
        return nums[findPivotIndex(nums)];
    }

    public int findPivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}
