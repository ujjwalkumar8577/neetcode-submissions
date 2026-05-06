class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return maxProfitHelper(prices, 0, 0);
    }

    public int maxProfitHelper(int[] prices, int i, int isHolding) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][isHolding] != null) {
            return dp[i][isHolding];
        }
        // not holding
        if (isHolding == 0) {
            return dp[i][isHolding] = Math.max(
                maxProfitHelper(prices, i+1, 1) - prices[i],
                maxProfitHelper(prices, i+1, 0)
            );
        }
        // holding
        return dp[i][isHolding] = Math.max(
            maxProfitHelper(prices, i+2, 0) + prices[i],
            maxProfitHelper(prices, i+1, 1)
        );
    }
}
