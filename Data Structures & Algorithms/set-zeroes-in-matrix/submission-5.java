class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean topRowZero = false;
        for (int j=0; j<n; j++) {
            if (matrix[0][j] == 0) {
                topRowZero = true;
                break;
            }
        }

        boolean leftColZero = false;
        for (int i=0; i<m; i++) {
            if (matrix[i][0] == 0) {
                leftColZero = true;
                break;
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (topRowZero) {
            Arrays.fill(matrix[0], 0);
        }
        if (leftColZero) {
            for (int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
