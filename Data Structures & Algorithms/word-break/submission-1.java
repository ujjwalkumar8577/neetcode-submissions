class Solution {
    Boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return helper(s, new HashSet<>(wordDict), 0);
    }

    private boolean helper(String s, Set<String> dict, int start) {
        if (start == s.length()) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (dict.contains(sub) && helper(s, dict, end)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}
