class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastPosition = new int[26];
        Arrays.fill(lastPosition, -1);
        char arr[] = s.toCharArray();
        for (int i=0; i<arr.length; i++) {
            lastPosition[arr[i] - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i=0; i<arr.length; i++) {
            end = Math.max(end, lastPosition[arr[i] - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i+1;
            }
        }
        return res;
    }
}
