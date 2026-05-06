class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        return climbStairsUtil(n, dp);
    }

    public int climbStairsUtil(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        if (n <= 1) {
            return dp[n] = 1;
        }
        return dp[n] = climbStairsUtil(n-1, dp) + climbStairsUtil(n-2, dp);        
    }
}
