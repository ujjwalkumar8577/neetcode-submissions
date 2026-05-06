class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return minDistanceHelper(word1, word2, 0, 0);
    }

    public int minDistanceHelper(String word1, String word2, int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }
        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = minDistanceHelper(word1, word2, i + 1, j + 1);
        }
        int insert = minDistanceHelper(word1, word2, i, j + 1);
        int delete = minDistanceHelper(word1, word2, i + 1, j);
        int replace = minDistanceHelper(word1, word2, i + 1, j + 1);
        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}
