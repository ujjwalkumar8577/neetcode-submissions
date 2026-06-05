class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for (int i=0; i<s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for (int i=0; i<s2.length(); i++) {
            freq[s2.charAt(i)-'a']--;
            if (i >= s1.length()) {
                freq[s2.charAt((i-s1.length()))-'a']++;
            }
            boolean flag = true;
            for (int j=0; j<26; j++) {
                if (freq[j] > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
