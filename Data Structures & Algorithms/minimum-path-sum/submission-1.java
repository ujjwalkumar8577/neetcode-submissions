class Solution {
    int INF = Integer.MAX_VALUE;
    int dp[][];
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return minPathSumHelper(grid, 0, 0);
    }

    public int minPathSumHelper(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return INF;
        }
        if (i == grid.length-1 && j == grid[0].length-1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = minPathSumHelper(grid, i, j+1);
        int down = minPathSumHelper(grid, i+1, j);
        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}