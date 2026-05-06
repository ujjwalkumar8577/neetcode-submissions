class Solution {
    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleaveHelper(s1, s2, s3, 0, 0);
    }

    public boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j) {
        int k = i+j;
        if (k >= s3.length()) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean res = false;
        if (!res &&  i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = res || isInterleaveHelper(s1, s2, s3, i+1, j);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || isInterleaveHelper(s1, s2, s3, i, j+1);
        }
        return dp[i][j] = res;
    }
}
