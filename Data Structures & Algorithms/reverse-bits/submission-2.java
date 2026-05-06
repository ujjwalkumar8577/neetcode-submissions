class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++) {
            if (getBit(n, i) == 1) {
                res = setBit(res, 31 - i);
            }
        }
        return res;
    }

    int getBit(int n, int pos) {
        // Not working for negative n
        // int tmp = (1 << pos) & n;
        // return tmp > 0 ? 1 : 0;
        return ((n >> pos) & 1);
    }

    int setBit(int n, int pos) {
        return (1 << pos) | n;
    }
}
