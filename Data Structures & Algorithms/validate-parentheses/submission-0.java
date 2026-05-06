class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> closingMap = new HashMap<>();
        closingMap.put('(', ')');
        closingMap.put('[', ']');
        closingMap.put('{', '}');
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tmp = stack.pop();
                char closing = closingMap.get(tmp);
                if (c != closing) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
