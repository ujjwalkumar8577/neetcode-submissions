class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int area = getArea(heights, l, r);
            max = Math.max(max, area);
            if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    public int getArea(int a[], int l, int r) {
        return Math.min(a[l], a[r]) * (r - l);
    }
}
