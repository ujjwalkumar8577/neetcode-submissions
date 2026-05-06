class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i=0; i<r; i++) {
            if(matrix[i][0] <= target && matrix[i][c-1] >= target) {
                return search(matrix[i], target);
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
