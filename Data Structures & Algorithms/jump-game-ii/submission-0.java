class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int l = 0;
        int r = 0;
        while (r < nums.length - 1) {
            int f = getFarthestPoint(nums, l, r);
            l = r+1;
            r = f;
            steps++;
        }
        return steps;
    }

    public int getFarthestPoint(int[] nums, int l, int r) {
        int max = r;
        for (int i=l; i<=r; i++) {
            max = Math.max(max, i+nums[i]);
        }
        return max;
    }
}
