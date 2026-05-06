class Solution {
    // Next greater element
    // pushing bigger element in stack is a problem
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        Stack<Pair> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && stack.peek().el < curr) {
                Pair pair = stack.pop();
                result[pair.pos] = i - pair.pos;
            }
            stack.push(new Pair(curr, i));
        }
        return result;
    }
}

class Pair {
    int el;
    int pos;
    
    public Pair(int e, int p) {
        this.el = e;
        this.pos = p;
    }
}