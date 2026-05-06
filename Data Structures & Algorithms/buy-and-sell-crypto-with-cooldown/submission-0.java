class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitHelper(prices, 0, -1);
    }

    public int maxProfitHelper(int[] prices, int i, int cp) {
        if (i >= prices.length) {
            return 0;
        }
        // not holding
        if (cp == -1) {
            return Math.max(
                maxProfitHelper(prices, i+1, prices[i]),
                maxProfitHelper(prices, i+1, -1)
            );
        }
        // holding
        return Math.max(
            (prices[i] - cp) + maxProfitHelper(prices, i+2, -1),
            maxProfitHelper(prices, i+1, cp)
        );
    }
}
