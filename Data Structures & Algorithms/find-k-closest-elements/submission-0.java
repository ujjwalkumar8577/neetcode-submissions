class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int ind = 0;
        while (ind < n && arr[ind] < x) {
            ind++;
        }
        List<Integer> res = new ArrayList();
        int i = ind -1;
        int j = ind;
        while (k-->0) {
            int diff1 = (i >= 0) ? Math.abs(arr[i] - x) : Integer.MAX_VALUE;
            int diff2 = (j < n) ? Math.abs(arr[j] - x) : Integer.MAX_VALUE;
            if (diff1 <= diff2) {
                res.add(arr[i]);
                i--;
            } else {
                res.add(arr[j]);
                j++;
            }
        }
        Collections.sort(res);
        return res;
    }
}