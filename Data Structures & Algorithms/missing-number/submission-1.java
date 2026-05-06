class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        // int sum = 0;
        // for (int e: nums) {
        //     sum += e;
        // }
        // return (n * (n+1) / 2) - sum;

        int ans = 0;
        for (int i=1; i<=n; i++) {
            ans ^= nums[i-1];
            ans ^= i;
        }
        return ans;
    }
}
