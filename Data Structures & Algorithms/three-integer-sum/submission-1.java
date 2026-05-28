class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int target = 0 - nums[i] - nums[j];
                if (set.contains(target)) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(target);
                    Collections.sort(tmp);
                    res.add(tmp);
                }
            }
            set.add(nums[i]);
        }
        return new ArrayList<>(res);
    }
}
