class Solution {
    public int findJudge(int n, int[][] trust) {
        int trustCount[] = new int[n+1];
        for (int[] tmp: trust) {
            trustCount[tmp[1]]++;
            trustCount[tmp[0]]--;
        }
        for (int i=1; i<=n; i++) {
            if (trustCount[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}