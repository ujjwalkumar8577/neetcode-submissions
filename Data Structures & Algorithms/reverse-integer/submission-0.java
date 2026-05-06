class Solution {
    public int reverse(int x) {
        long num = 1L*x;
        boolean isNegative = false;
        if(num<0) {
            isNegative = true;
            num = -num;
        }
        long ans = 0L;
        while(num>0) {
            ans = ans*10 + num%10;
            num = num/10;
        }
        
        if(ans>2147483647)
            return 0;
        
        if(isNegative)
            return (int)(-ans);
        else
            return (int)ans;
    }
}