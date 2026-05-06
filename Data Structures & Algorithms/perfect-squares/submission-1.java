class Solution {
    int dp[];
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        int res = numSquaresHelper(n);
        if (res == 10001) {
            return -1;
        }
        return res;
    }

    public int numSquaresHelper(int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int res = 10001;
        for (int i = 1; i*i <= n; i++) {
            res = Math.min(res, 1 + numSquaresHelper(n - i*i));
        }
        return dp[n] = res;
    }
}