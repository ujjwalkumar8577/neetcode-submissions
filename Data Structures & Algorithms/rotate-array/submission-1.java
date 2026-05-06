class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int tmp[] = new int[n];
        for (int i=0; i<n; i++) {
            tmp[i] = nums[i];
        }
        for (int i=0; i<n; i++) {
            nums[i] = tmp[(i + n - k) % n];
        }
    }
}