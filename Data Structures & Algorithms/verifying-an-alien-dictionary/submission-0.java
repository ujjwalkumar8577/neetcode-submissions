class Solution {
    int pos[];
    public boolean isAlienSorted(String[] words, String order) {
        pos = new int[26];
        for (int i=0; i<26; i++) {
            pos[order.charAt(i) - 'a'] = i;
        }
        for (int i=0; i<words.length-1; i++) {
            if (!compareWords(words[i], words[i+1])) {
                return false;
            }
        }
        return true;
    }

    public boolean compareWords(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0;
        while (i<m && i<n) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return compare(word1.charAt(i), word2.charAt(i));
            }
            i++;
        }
        return m <= n;
    }

    public boolean compare(char a, char b) {
        return pos[a - 'a'] <= pos[b - 'a'];
    }
}