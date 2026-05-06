class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int start = 0;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            map.put(c, i);
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
