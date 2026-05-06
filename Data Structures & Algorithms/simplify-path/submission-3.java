class Solution {
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        boolean isLastCharSlash = false;
        for (int i=0; i<path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (!isLastCharSlash) {
                    isLastCharSlash = true;
                    sb.append(c);
                }
            } else {
                isLastCharSlash = false;
                sb.append(c);
            }
        }
        path = sb.toString();
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part: parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (part.equals(".")) {

            } else if (!part.equals("")) {
                stack.push(part);
            }
        }
        Stack<String> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        StringBuilder res = new StringBuilder();
        while (!stack2.isEmpty()) {
            res.append('/');
            res.append(stack2.pop());
        }
        String ans = res.toString();
        if (ans.equals("")) {
            return "/";
        }
        return ans;        
    }
}