class Solution {
    public int[] plusOne(int[] digits) {
        boolean allNines = true;
        for (int e: digits) {
            if (e != 9) {
                allNines = false;
                break;
            }
        }
        int n = digits.length;
        int ansLength = allNines ? n+1 : n;
        int ans[] = new int[ansLength];
        int carry = 1;
        int j = ansLength - 1;
        for (int i=n-1; i>=0; i--) {
            int tmp = digits[i] + carry;
            carry = tmp/10;
            ans[j--] = tmp%10;
        }
        if (carry > 0) {
            ans[j] = carry;
        }
        return ans;
    }
}
