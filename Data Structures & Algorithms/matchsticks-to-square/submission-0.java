class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int e: matchsticks) {
            sum += e;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int sides[] = new int[4];
        return makesquareHelper(matchsticks, sides, 0, sum);
    }

    public boolean makesquareHelper(int[] matchsticks, int[] sides, int i, int sum) {
        if (i >= matchsticks.length) {
            return (sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]);
        }
        boolean res = false;
        for (int j=0; j<4; j++) {
            if (sides[j] >= sum/4) {
                continue;
            }
            sides[j] += matchsticks[i];
            res = res || makesquareHelper(matchsticks, sides, i+1, sum);
            if (res) {
                return true;
            }
            sides[j] -= matchsticks[i];
        }
        return res;
    }
}