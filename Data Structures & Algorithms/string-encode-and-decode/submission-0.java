class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str: strs) {
            int n = str.length();
            res.append(n);
            res.append('#');
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        char c[] = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        int num = 0;
        for (int i=0; i<c.length; i++) {
            if (Character.isDigit(c[i])) {
                num = num*10 + (c[i] - '0');
            } else if (c[i] == '#') {
                String tmp = str.substring(i+1, i+1+num);
                res.add(tmp);
                i += num;
                num = 0;
            }
        }
        return res;
    }
}
