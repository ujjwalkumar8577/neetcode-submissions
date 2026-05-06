class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }
        for (int i=0; i<9; i+=3) {
            for (int j=0; j<9; j+=3) {
                if (!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidBox(char[][] board, int m, int n) {
        boolean present[] = new boolean[9];
        for (int i=m; i<m+3; i++) {
            for (int j=n; j<n+3; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!Character.isDigit(c) || present[c-'1']) {
                    return false;
                }
                present[c-'1'] = true;
            }
        }
        return true;
    }

    public boolean isValidRow(char[][] board, int i) {
        boolean present[] = new boolean[9];
        for (int j=0; j<9; j++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            }
            System.out.println(c);
            if (!Character.isDigit(c) || present[c-'1']) {
                return false;
            }
            present[c-'1'] = true;
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int j) {
        boolean present[] = new boolean[9];
        for (int i=0; i<9; i++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            }
            if (!Character.isDigit(c) || present[c-'1']) {
                return false;
            }
            present[c-'1'] = true;
        }
        return true;
    }
}
