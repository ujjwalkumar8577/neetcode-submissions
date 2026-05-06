class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int e: stones) {
            pq.add(e);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x > y) {
                pq.add(x - y);
            }
        }
        return pq.size() > 0 ? pq.peek() : 0;
    }
}
