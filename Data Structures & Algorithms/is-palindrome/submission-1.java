class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        s = s.toLowerCase();
        while (l <= r) {
            while (l < n && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < n && r >= 0 && s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
