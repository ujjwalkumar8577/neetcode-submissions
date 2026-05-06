class Solution {
    int ans;

    public int totalNQueens(int n) {
        ans = 0;
        boolean board[][] = new boolean[n][n];
        nQueensHelper(board, 0);
        return ans;
    }

    public void nQueensHelper(boolean board[][], int i) {
        int n = board.length;
        if (i >= n) {
            ans++;
            return;
        }
        for (int j=0; j<n; j++) {
            if (!canPlaceQueen(board, i, j)) {
                continue;
            }
            board[i][j] = true;
            nQueensHelper(board, i+1);
            board[i][j] = false;
        }
    }

    public boolean canPlaceQueen(boolean board[][], int i, int j) {
        int n = board.length;
        for (int row = 0; row < i; row++) {
            if (board[row][j]) return false;
        }
        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col]) return false;
        }
        for (int row = i - 1, col = j + 1; row >= 0 && col < n; row--, col++) {
            if (board[row][col]) return false;
        }
        return true;
    }
}