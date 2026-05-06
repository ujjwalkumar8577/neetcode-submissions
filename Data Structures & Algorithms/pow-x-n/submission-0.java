class Solution {
    public double myPow(double x, int n) {
        if (x==0) {
            return 0;
        }
        if (n==0) {
            return 1;
        }
        if (n<0) {
            return 1.0/myPow(x, -1*n);
        }
        double pow = myPow(x, n/2);
        if (n%2 == 0) {
            return pow*pow;
        } else {
            return pow*pow*x;
        }
    }
}
