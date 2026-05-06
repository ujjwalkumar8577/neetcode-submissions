class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean vis[][] = new boolean[m][n];
        ArrayList<ArrayList<Integer>> pacific = new ArrayList<>();
        ArrayList<ArrayList<Integer>> atlantic = new ArrayList<>();
        for (int i=0; i<n; i++) {
            visit(heights, 0, i, pacific, vis);
        }
        for (int i=0; i<m; i++) {
            visit(heights, i, 0, pacific, vis);
        }
        vis = new boolean[m][n];
        for (int i=0; i<n; i++) {
            visit(heights, m-1, i, atlantic, vis);
        }
        for (int i=0; i<m; i++) {
            visit(heights, i, n-1, atlantic, vis);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (ArrayList<Integer> al: pacific) {
            if (atlantic.contains(al)) {
                res.add(al);
            }
        }
        return res;
    }

    public void visit(int heights[][], int i, int j, ArrayList<ArrayList<Integer>> set, boolean vis[][]) {
        if (i<0 || i>=heights.length || j<0 || j>=heights[0].length) {
            return;
        }
        if (vis[i][j]) {
            return;
        }
        vis[i][j] = true;
        ArrayList<Integer> al = new ArrayList<>();
        al.add(i);
        al.add(j);
        set.add(al);
        if (i<heights.length-1 && heights[i][j] <= heights[i+1][j]) {
            visit(heights, i+1, j, set, vis);
        }
        if (i>0 && heights[i][j] <= heights[i-1][j]) {
            visit(heights, i-1, j, set, vis);
        }
        if (j<heights[0].length-1 && heights[i][j] <= heights[i][j+1]) {
            visit(heights, i, j+1, set, vis);
        }
        if (j>0 && heights[i][j] <= heights[i][j-1]) {
            visit(heights, i, j-1, set, vis);
        }
    }
}
