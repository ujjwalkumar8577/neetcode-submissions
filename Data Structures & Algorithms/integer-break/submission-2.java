class Solution {
    // will be maximized around e
    // since we have to choose an integer, we can choose 3 (nearest to e)
    public int integerBreak(int n) {
        if (n <= 3) {
            return n-1;
        }
        int divisor = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int)Math.pow(3, divisor);
        }
        if (remainder == 1) {
            return (int)Math.pow(3, divisor-1)*4;
        }
        return (int)Math.pow(3, divisor)*2;
    }
}