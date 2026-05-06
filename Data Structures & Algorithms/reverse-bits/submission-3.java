class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;           // make space for next bit
            res |= (n & 1);      // copy LSB of n
            n >>>= 1;            // unsigned right shift
        }
        return res;
    }
}