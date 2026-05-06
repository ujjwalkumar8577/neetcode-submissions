class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        HashSet<Long> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    long tmp = target - (0L + nums[i] + nums[j] + nums[k]);
                    if (set.contains(tmp)) {
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add((int)tmp);
                        Collections.sort(quad);
                        res.add(quad);
                    }
                }
            }
            set.add((long)nums[i]);
        }
        return new ArrayList<>(res);
    }
}