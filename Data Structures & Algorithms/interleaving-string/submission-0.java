class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isInterleaveHelper(s1, s2, s3, 0, 0);
    }

    public boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j) {
        int k = i+j;
        if (k >= s3.length()) {
            return true;
        }
        boolean res = false;
        if (!res &&  i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            res = res || isInterleaveHelper(s1, s2, s3, i+1, j);
        }
        if (!res && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            res = res || isInterleaveHelper(s1, s2, s3, i, j+1);
        }
        return res;
    }
}
