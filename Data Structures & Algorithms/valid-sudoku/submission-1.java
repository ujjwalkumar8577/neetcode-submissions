class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
            if (!isValidColumn(board, i)) {
                return false;
            }
            for (int j=0; j<9; j++) {
                if (i%3 == 0 && j%3 == 0 && !isValidBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidBox(char[][] board, int m, int n) {
        boolean present[] = new boolean[10];
        for (int i=m; i<m+3; i++) {
            for (int j=n; j<n+3; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (present[c-'1']) {
                    return false;
                }
                present[c-'1'] = true;
            }
        }
        return true;
    }

    public boolean isValidRow(char[][] board, int i) {
        boolean present[] = new boolean[10];
        for (int j=0; j<9; j++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            }
            if (present[c-'1']) {
                return false;
            }
            present[c-'1'] = true;
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int j) {
        boolean present[] = new boolean[10];
        for (int i=0; i<9; i++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            }
            if (present[c-'1']) {
                return false;
            }
            present[c-'1'] = true;
        }
        return true;
    }
}
