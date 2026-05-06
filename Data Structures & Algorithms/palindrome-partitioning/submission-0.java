class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionHelper(s, 0, res, new ArrayList<>());
        return res;
    }

    public void partitionHelper(String s, int i, List<List<String>> res, List<String> tmp) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(tmp));
        }
        for (int j=i; j<s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                tmp.add(s.substring(i, j+1));
                partitionHelper(s, j+1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
