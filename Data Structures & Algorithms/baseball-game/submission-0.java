class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String op: operations) {
            if (op.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                int c = a + b;
                stack.push(a);
                stack.push(c);
            } else if (op.equals("D")) {
                int tmp = 2 * stack.peek();
                stack.push(tmp);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}