class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i=0; i<26; i++) {
            tmp.add(0);
        }
        for (String str: strs) {
            ArrayList<Integer> freq = new ArrayList<>(tmp);
            for (char c: str.toCharArray()) {
                freq.set(c-'a', freq.get(c-'a') + 1);
            }
            if (!map.containsKey(freq)) {
                map.put(freq, new ArrayList<String>());
            }
            map.get(freq).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
