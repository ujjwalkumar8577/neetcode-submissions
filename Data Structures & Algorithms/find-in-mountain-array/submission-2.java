/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeakIndex(mountainArr);
        int res = binarySearch(mountainArr, target, 0, peak - 1, true);
        if (res != -1) {
            return res;
        }
        res = binarySearch(mountainArr, target, peak, n - 1, false);
        return res;
    }

    public int findPeakIndex(MountainArray arr) {
        int l = 0;
        int r = arr.length() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr.get(m) < arr.get(m + 1)) {
                // We are on the increasing side — peak is to the right
                l = m + 1;
            } else {
                // We are on the decreasing side — peak could be mid or to the left
                r = m;
            }
        }
        // l == r — both point to the peak
        return l;
    }

    public int binarySearch(MountainArray arr, int target, int l, int r, boolean isAscending) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int tmp = arr.get(m);
            if (tmp == target) {
                return m;
            }
            if (isAscending) {
                if (tmp < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (tmp < target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}