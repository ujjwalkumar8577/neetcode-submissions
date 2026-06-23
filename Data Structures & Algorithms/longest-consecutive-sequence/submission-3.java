class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int e: nums) {
            set.add(e);
        }
        int max = 0;
        for (int e: set) {
            // Skip non starting elements
            if (set.contains(e-1)) {
                continue;
            }
            int count = 0;
            int start = e;
            while (set.contains(start)) {
                count++;
                start++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
