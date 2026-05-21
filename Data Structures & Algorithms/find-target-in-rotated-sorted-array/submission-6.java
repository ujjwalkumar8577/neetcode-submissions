class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivotIndex(nums);
        int a = binarySearch(nums, 0, pivot-1, target);
        if (a != -1) {
            return a;
        }
        return binarySearch(nums, pivot, nums.length-1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
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
