class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (find(board, word, i, j, 0, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word, int i, int j, int k, boolean[][] vis) {
        if (k==word.length()) {
            return true;
        }
        if (i<0 || i>=board.length || j<0 || j>=board[0].length) {
            return false;
        }
        if (vis[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        vis[i][j] = true;
        boolean res = find(board, word, i, j+1, k+1, vis)
            || find(board, word, i+1, j, k+1, vis)
            || find(board, word, i, j-1, k+1, vis)
            || find(board, word, i-1, j, k+1, vis);
        vis[i][j] = false;
        return res;
    }
}
