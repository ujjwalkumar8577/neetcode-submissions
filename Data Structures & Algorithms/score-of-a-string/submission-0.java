class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i=1; i<s.length(); i++) {
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i);
            score += Math.abs(c2 - c1);
        }
        return score;
    }
}