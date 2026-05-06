class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate("", n, n, res);
        return res;
    }

    public void generate(String str, int open, int close, ArrayList<String> res) {
        if (close == 0) {
            res.add(str);
            return;
        }
        if (open > 0) {
            generate(str+'(', open-1, close, res);
        }
        if (close > open) {
            generate(str+')', open, close-1, res);
        }
    }
}
