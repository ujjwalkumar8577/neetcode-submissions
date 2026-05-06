class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int top = 0;
        int bottom = r - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (target < matrix[mid][0]) {
                bottom = mid - 1;
            } else if (target > matrix[mid][c - 1]) {
                top = mid + 1;
            } else {
                return search(matrix[mid], target);
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = l + ((r - l) / 2);
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
