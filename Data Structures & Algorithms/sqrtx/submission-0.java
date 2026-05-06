class Solution {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l)/2;
            long square = 1L * mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l-1;
    }
}