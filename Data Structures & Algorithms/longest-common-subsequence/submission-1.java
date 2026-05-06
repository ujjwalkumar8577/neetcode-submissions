class Solution {
    int dp[][];

    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return longestCommonSubsequenceHelper(text1, text2, 0, 0);
    }

    public int longestCommonSubsequenceHelper(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j>= text2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + longestCommonSubsequenceHelper(text1, text2, i+1, j+1);
        }
        return dp[i][j] = Math.max(
            longestCommonSubsequenceHelper(text1, text2, i+1, j),
            longestCommonSubsequenceHelper(text1, text2, i, j+1)
        );
    }
}
