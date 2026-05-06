class Solution {
    public int numDecodings(String s) {
        return numDecodingsHelper(s, 0);
    }

    public int numDecodingsHelper(String s, int i) {
        int n = s.length();
        if (i >= n) {
            return 1;
        }
        int res = 0;
        if (i+1 <= n && isValidSubstring(s.substring(i, i+1))) {
            res += numDecodingsHelper(s, i+1);
        }
        if (i+2 <= n && isValidSubstring(s.substring(i, i+2))) {
            res += numDecodingsHelper(s, i+2);
        }
        return res;        
    }

    public boolean isValidSubstring(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        return Integer.parseInt(s) <= 26;
    }
}
