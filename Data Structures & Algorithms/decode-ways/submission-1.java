class Solution {
    int dp[];
    public int numDecodings(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        char arr[] = s.toCharArray();
        return numDecodingsHelper(arr, 0);
    }

    public int numDecodingsHelper(char arr[], int i) {
        int n = arr.length;
        if (i >= n) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int res = 0;
        if (i+1 <= n && isValidSubstring(arr, i, i+1)) {
            res += numDecodingsHelper(arr, i+1);
        }
        if (i+2 <= n && isValidSubstring(arr, i, i+2)) {
            res += numDecodingsHelper(arr, i+2);
        }
        return dp[i] = res;        
    }

    public boolean isValidSubstring(char arr[], int start, int end) {
        if (arr[start] == '0') {
            return false;
        }
        int num = 0;
        for (int i=start; i<end; i++) {
            int tmp = arr[i] - '0';
            num = num*10 + tmp;
        }
        return num <= 26;
    }
}
