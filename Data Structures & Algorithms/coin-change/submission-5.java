class Solution {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int res = coinChangeHelper(coins, amount);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public int coinChangeHelper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int e: coins) {
            if (e <= amount) {
                int tmp = coinChangeHelper(coins, amount - e);
                if (tmp != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + tmp);
                }
            }
        }
        return dp[amount] = res;
    }
}
