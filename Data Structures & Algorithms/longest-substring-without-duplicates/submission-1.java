class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> pos = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (pos.containsKey(c) && pos.get(c) >= start) {
                start = pos.get(c) + 1;
            }
            pos.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
