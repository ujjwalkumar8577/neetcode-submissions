class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        int k = s1.length();
        for (int i=0; i<k; i++) {
            freq[s1.charAt(i) - 'a']--;
        }
        for (int i=0; i<s2.length(); i++) {
            freq[s2.charAt(i) - 'a']++;
            if (i >= k) {
                freq[s2.charAt(i-k) - 'a']--;
            }
            boolean flag = true;
            for (int j=0; j<26; j++) {
                if (freq[j] < 0) {
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
