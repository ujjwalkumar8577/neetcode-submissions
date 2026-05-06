class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combineHelper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    public void combineHelper(int n, int k, int start, ArrayList<Integer> tmp, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=start; i <= n; i++) {
            tmp.add(i);
            combineHelper(n, k-1, i+1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}