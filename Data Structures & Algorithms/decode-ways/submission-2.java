class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return numDecodingsHelper(s, 0);
    }

    public int numDecodingsHelper(String s, int i) {
        if (i >= s.length()) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int res = 0;
        if (isValidSubstring(s, i, i+1)) {
            res += numDecodingsHelper(s, i+1);
        }
        if (isValidSubstring(s, i, i+2)) {
            res += numDecodingsHelper(s, i+2);
        }
        return dp[i] = res;
    }

    public boolean isValidSubstring(String s, int i, int j) {
        if (i >= s.length() || j> s.length()) {
            return false;
        }
        if (s.charAt(i) == '0') {
            return false;
        }
        return Integer.parseInt(s.substring(i, j)) <= 26;
    }
}
