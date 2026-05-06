class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build number (could be >9, so multiply)
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push current number and string state
                counts.push(num);
                resultStack.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // Pop last count and last string
                int repeat = counts.pop();
                StringBuilder decoded = resultStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(curr);
                }
                curr = decoded;
            } else {
                // Just add normal chars
                curr.append(c);
            }
        }

        return curr.toString();
    }
}