class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int j = 0;
        int a = -1;
        int b = -1;
        while (j < s.length()) {
            if (!isValidFreq(map)) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                }
                j++;
            }
            while (i < j && isValidFreq(map)) {
                if ((a == -1 && b == -1) || (j - i < b - a)) {
                    a = i;
                    b = j;
                }
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                }
                i++;
            }
        }
        if (a == -1 && b == -1) {
            return "";
        }
        return s.substring(a, b);
    }

    public boolean isValidFreq(HashMap<Character, Integer> map) {
        for (int e: map.values()) {
            if (e > 0) {
                return false;
            }
        }
        return true;
    }
}
