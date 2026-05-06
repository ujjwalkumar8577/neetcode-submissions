class StockSpanner {
    Stack<Integer> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        Stack<Integer> tmp = new Stack<>();
        int span = 1;
        while (!stack.isEmpty() && stack.peek() <= price) {
            int e = stack.pop();
            tmp.push(e);
            span++;
        }
        while (!tmp.isEmpty()) {
            int e = tmp.pop();
            stack.push(e);
        }
        stack.push(price);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */