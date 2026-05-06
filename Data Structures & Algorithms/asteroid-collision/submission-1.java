class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<asteroids.length; i++) {
            int tmp = asteroids[i];
            while (!stack.isEmpty() && stack.peek() > 0 && tmp < 0) {
                int top = stack.pop();
                if (Math.abs(top) > Math.abs(tmp)) {
                    tmp = 0;
                    stack.push(top);
                    break;
                } else if (Math.abs(top) == Math.abs(tmp)) {
                    tmp = 0;
                    break;
                }
            }
            if (tmp != 0) {
                stack.push(tmp);
            }
        }
        int res[] = new int[stack.size()];
        for (int i=res.length-1; i>=0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}