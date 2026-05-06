class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int str = 0;
        int end = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            int dev1 = checkPalindrome(s, n, i, i);
            int dev2 = checkPalindrome(s, n, i, i+1);
            if (2*dev1 - 1 > maxLen) {
                maxLen = 2*dev1 - 1;
                str = i-dev1+1;
                end = i+dev1-1;
            }
            if (2*dev2 > maxLen) {
                maxLen = 2*dev2;
                str = i-dev2+1;
                end = i+dev2;
            }
        }
        return s.substring(str, end+1);
    }

    public int checkPalindrome(String s, int n, int l, int r) {
        int dev = 0;
        while (l-dev >= 0 && r+dev < n && s.charAt(l-dev) == s.charAt(r+dev)) {
            dev++;
        }
        return dev;
    }
}
