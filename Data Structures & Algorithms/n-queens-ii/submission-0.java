class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = solveNQueens(n);
        return res.size();
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean board[][] = new boolean[n][n];
        nQueensHelper(res, board, 0);
        return res;
    }

    public void nQueensHelper(List<List<String>> res, boolean board[][], int i) {
        int n = board.length;
        if (i >= n) {
            res.add(getBoard(board));
            return;
        }
        for (int j=0; j<n; j++) {
            if (!canPlaceQueen(board, i, j)) {
                continue;
            }
            board[i][j] = true;
            nQueensHelper(res, board, i+1);
            board[i][j] = false;
        }
    }

    public List<String> getBoard(boolean board[][]) {
        int n = board.length;
        List<String> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                char c = board[i][j] ? 'Q' : '.';
                sb.append(c);
            }
            list.add(sb.toString());
        }
        return list;
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