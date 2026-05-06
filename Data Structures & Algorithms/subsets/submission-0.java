class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        calculate(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void calculate(List<List<Integer>> res, List<Integer> tmp, int[] nums, int i) {
        if (i >= nums.length) {
            res.add(tmp);
            return;
        }
        calculate(res, new ArrayList<Integer>(tmp), nums, i+1);
        tmp.add(nums[i]);
        calculate(res, new ArrayList<Integer>(tmp), nums, i+1);
    }
}
