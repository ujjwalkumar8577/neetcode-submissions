class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int e: piles) {
            max = Math.max(max, e);
        }
        int l = 1;
        int r = max;
        while (l < r) {
            int m = l + (r - l) / 2;
            int tmp = getHours(piles, m);
            if (tmp > h) {
                l = m+1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public int getHours(int[] piles, int rate) {
        int res = 0;
        for (int e: piles) {
            res += Math.ceil(1.0 * e / rate);
        }
        return res;
    }
}
