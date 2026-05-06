class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        int newNumber = 0;
        while (n > 0) {
            int d = n%10;
            newNumber += (d*d);
            n /= 10;
        }
        return isHappy(newNumber);
    }
}
