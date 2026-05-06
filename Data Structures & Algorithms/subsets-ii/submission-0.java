class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        calculate(res, new ArrayList<Integer>(), nums, 0);
        return new ArrayList<>(res);
    }

    public void calculate(Set<List<Integer>> res, List<Integer> tmp, int[] nums, int i) {
        if (i >= nums.length) {
            tmp.sort(null);
            res.add(tmp);
            return;
        }
        calculate(res, new ArrayList<Integer>(tmp), nums, i+1);
        tmp.add(nums[i]);
        calculate(res, new ArrayList<Integer>(tmp), nums, i+1);
    }
}
