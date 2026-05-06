class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate("", 0, 2*n, 0, 0, res);
        return res;
    }

    public void generate(String str, int i, int n, int open, int close, ArrayList<String> res) {
        if (close > open || open > n/2) {
            return;
        }
        if (i>=n) {
            res.add(str);
            return;
        }
        String str1 = str + '(';
        generate(str1, i+1, n, open+1, close, res);
        String str2 = str + ')';
        generate(str2, i+1, n, open, close+1, res);
    }
}
