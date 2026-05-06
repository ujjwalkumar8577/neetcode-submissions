class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            int dev1 = checkPalindrome(s, n, i, i);
            int dev2 = checkPalindrome(s, n, i, i+1);
            if (2*dev1 - 1 > 0) {
                count += dev1;
            }
            if (2*dev2 > 0) {
                count += dev2; 
            }
        }
        return count;
    }

    public int checkPalindrome(String s, int n, int l, int r) {
        int dev = 0;
        while (l-dev >= 0 && r+dev < n && s.charAt(l-dev) == s.charAt(r+dev)) {
            dev++;
        }
        return dev;
    }
}
