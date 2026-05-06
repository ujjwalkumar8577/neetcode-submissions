class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> freq;
        ArrayList<Integer> tmp = new ArrayList<>(26);
        for (int i=0; i<26; i++) {
            tmp.add(0);
        }
        for (String str: strs) {
            freq =  new ArrayList<>(tmp);
            for (char c: str.toCharArray()) {
                int ind = c - 'a';
                freq.set(ind, freq.get(ind) + 1);
            }
            if (!map.containsKey(freq)) {
                map.put(freq, new ArrayList<>());
            }
            map.get(freq).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
