class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        al.add(1);
        ans.add(al);
        for(int i=1; i<numRows; i++) {
            al = new ArrayList<>();
            al.add(1);
            for(int j=1; j<i; j++) {
                int a = ans.get(i-1).get(j-1);
                int b = ans.get(i-1).get(j);
                al.add(a+b);
            }
            al.add(1);
            ans.add(al);
        }
        
        return ans;
    }
}