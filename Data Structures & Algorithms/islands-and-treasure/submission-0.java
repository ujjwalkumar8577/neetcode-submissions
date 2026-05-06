class Solution {
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }
        q.add(null);
        int level = 1;
        while (!q.isEmpty()) {
            Pair tmp = q.poll();
            if (tmp == null) {
                if (!q.isEmpty()) {
                    level++;
                    q.add(null);
                }
                continue;
            }
            int i = tmp.i;
            int j = tmp.j;
            if (i+1<grid.length && grid[i+1][j] == INF) {
                grid[i+1][j] = level;
                q.add(new Pair(i+1, j));
            }
            if (j+1<grid[0].length && grid[i][j+1] == INF) {
                grid[i][j+1] = level;
                q.add(new Pair(i, j+1));
            }
            if (i >= 1 && grid[i-1][j] == INF) {
                grid[i-1][j] = level;
                q.add(new Pair(i-1, j));
            }
            if ( j >=1 && grid[i][j-1] == INF) {
                grid[i][j-1] = level;
                q.add(new Pair(i, j-1));
            }
        }
    }
}

class Pair {
    int i, j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}