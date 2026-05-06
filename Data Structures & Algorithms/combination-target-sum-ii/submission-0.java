class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        combinationSum2Helper(candidates, target, 0, res, new ArrayList<>());
        return new ArrayList<>(res);
    }

    public void combinationSum2Helper(int[] candidates, int target, int i, HashSet<ArrayList<Integer>> res, ArrayList<Integer> tmp) {
        if (i>=candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (candidates[i] <= target) {
            tmp.add(candidates[i]);
            combinationSum2Helper(candidates, target-candidates[i], i+1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
        combinationSum2Helper(candidates, target, i+1, res, tmp);
    }
}
