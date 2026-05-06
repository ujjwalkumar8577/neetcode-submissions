class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            String str = tokens[i];
            int tmp = 0;
            if (str.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                tmp = b + a;
            } else if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                tmp = b - a;
            } else if (str.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                tmp = b * a;
            } else if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                tmp = b / a;                
            } else {
                tmp = Integer.parseInt(str);
            }
            stack.push(tmp);
        }
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.pop();
    }
}
