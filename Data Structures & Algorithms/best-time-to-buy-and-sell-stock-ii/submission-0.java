class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i=0; i<prices.length-1; i++) {
            int tmp = prices[i+1]-prices[i];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }
}