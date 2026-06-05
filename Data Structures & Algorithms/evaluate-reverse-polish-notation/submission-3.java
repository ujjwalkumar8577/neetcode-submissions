class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            boolean isOperator = token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
            if (isOperator) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calculate(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public int calculate(int a, int b, String operator) {
        if (operator.equals("+")) {
            return b + a;
        }
        if (operator.equals("-")) {
            return b - a;
        }
        if (operator.equals("*")) {
            return b * a;
        }
        if (operator.equals("/")) {
            return b / a;
        }
        return a;
    }
}
