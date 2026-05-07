class Solution {

    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length());
            sb.append(",");
        }
        sb.append("#");
        for (String str: strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.equals("")) {
            return new ArrayList<String>();
        }
        int hashIndex = str.indexOf('#');
        String lengths[] = str.substring(0, hashIndex-1).split(",");
        List<String> res = new ArrayList<>();
        int tmp = hashIndex + 1;
        for (String len: lengths) {
            int l = Integer.parseInt(len);
            String s = str.substring(tmp, tmp+l);
            res.add(s);
            tmp += l;
        }
        return res;
    }
}
