class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int e: prices) {
            if (e > minSoFar) {
                maxProfit = Math.max(maxProfit, e - minSoFar);
            }
            minSoFar = Math.min(minSoFar, e);
        }
        return maxProfit;
    }
}
