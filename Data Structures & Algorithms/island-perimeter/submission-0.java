class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    res -= getNeighborCount(grid, m, n, i, j);
                }
            }
        }
        return res;
    }
    public int getNeighborCount(int[][] grid, int m, int n, int i, int j) {
        int count = 0;
        if (i>0 && grid[i-1][j] == 1) {
            count++;
        }
        if (j>0 && grid[i][j-1] == 1) {
            count++;
        }
        if (i<m-1 && grid[i+1][j] == 1) {
            count++;
        }
        if (j<n-1 && grid[i][j+1] == 1) {
            count++;
        }
        return count;
    }
}