class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean picked[] = new boolean[nums.length];
        permuteHelper(nums, picked, new ArrayList<>(), res);
        return res;
    }

    public void permuteHelper(int[] nums, boolean[] picked, List<Integer> tmp, List<List<Integer>> res) {
        if (nums.length == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (picked[i]) {
                continue;
            }
            picked[i] = true;
            tmp.add(nums[i]);
            permuteHelper(nums, picked, tmp, res);
            tmp.remove(tmp.size() - 1);
            picked[i] = false;
        }
    }
}
