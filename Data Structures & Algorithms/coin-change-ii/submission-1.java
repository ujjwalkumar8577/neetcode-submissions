class Solution {
    int dp[][];
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return changeHelper(amount, coins, 0);
    }

    public int changeHelper(int amount, int[] coins, int i) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (i >= coins.length) {
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        return dp[i][amount] = changeHelper(amount-coins[i], coins, i)
            + changeHelper(amount, coins, i+1);
    }
}
