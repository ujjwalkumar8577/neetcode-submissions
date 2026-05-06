class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e: nums) {
            int freq = map.getOrDefault(e, 0) + 1;
            map.put(e, freq);
        }
        int n = nums.length;
        List<Integer>[] bucket = new List[n + 1];
        for (int e: map.keySet()) {
            int freq = map.get(e);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(e);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=n; i>=0 && ans.size()<k; i--) {
            if (bucket[i] != null) {
                ans.addAll(bucket[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
