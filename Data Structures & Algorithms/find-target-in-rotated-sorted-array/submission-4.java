class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int pivot = 0;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] < nums[m]) {
                l = m + 1;
            }
            if (nums[m] < nums[r]) {
                r = m - 1;
            }
            if (m < n-1 && nums[m] > nums[m+1]) {
                pivot = m;
                break;
            }
        }
        System.out.println(pivot);
        int ind1 = binarySearch(nums, 0, pivot, target);
        System.out.println("ind1 " + ind1);
        if (ind1 != -1) {
            return ind1;
        }
        int ind2 = binarySearch(nums, pivot+1, n-1, target);
        System.out.println("ind2 " + ind2);
        return ind2;
    }

    public int binarySearch(int nums[], int l, int r, int target) {
        System.out.println(l + " " + r + " " + target);
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
