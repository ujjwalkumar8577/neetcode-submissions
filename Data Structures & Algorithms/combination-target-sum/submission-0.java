class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        combinationSumUtil(nums, target, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    public void combinationSumUtil(int[] nums, int target, ArrayList<Integer> tmp, HashSet<ArrayList<Integer>> res) {
        if (target == 0) {
            Collections.sort(tmp);
            res.add(tmp);
            return;
        }
        for (int e: nums) {
            if (target - e >= 0) {
                tmp.add(e);
                combinationSumUtil(nums, target-e, new ArrayList<>(tmp), res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
