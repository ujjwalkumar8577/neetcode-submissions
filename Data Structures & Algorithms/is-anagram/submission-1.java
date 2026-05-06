class Solution {
    public boolean isAnagram(String s, String t) {
        int freq[] = new int[26];
        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int j=0; j<t.length(); j++) {
            freq[t.charAt(j) - 'a']--;
        }
        for (int k=0; k<26; k++) {
            if (freq[k] != 0) {
                return false;
            }
        }
        return true;
    }
}
