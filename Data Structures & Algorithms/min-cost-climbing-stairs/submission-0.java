class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(cost, 0), minCost(cost, 1));
    }

    public int minCost(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        return cost[i] + Math.min(minCost(cost, i+1), minCost(cost, i+2));
    }
}
