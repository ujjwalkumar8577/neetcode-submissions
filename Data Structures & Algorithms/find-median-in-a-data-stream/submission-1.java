class MedianFinder {
    Queue<Integer> leftHeap;
    Queue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (rightHeap.size() > 0 && num > rightHeap.peek()) {
            rightHeap.add(num);
        } else {
            leftHeap.add(num);
        }
        if (leftHeap.size() - rightHeap.size() > 1) {
            int tmp = leftHeap.poll();
            rightHeap.add(tmp);
        }
        if (rightHeap.size() - leftHeap.size() > 1) {
            int tmp = rightHeap.poll();
            leftHeap.add(tmp);
        }
    }
    
    public double findMedian() {
        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        }
        if (rightHeap.size() > leftHeap.size()) {
            return rightHeap.peek();
        }
        int leftVal = leftHeap.peek();
        int rightVal = rightHeap.peek();
        return (leftVal + rightVal) / 2.0;
    }
}
