class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        if (n == 0) {
            return res;
        }
        res[1] = 1;
        int tmp = 1;
        for (int i=2; i<=n; i++) {
            if (i == tmp*2) {
                tmp *= 2;
                res[i] = 1;
                continue;
            }
            res[i] = 1 + res[i-tmp];
        }
        return res;
    }
}
