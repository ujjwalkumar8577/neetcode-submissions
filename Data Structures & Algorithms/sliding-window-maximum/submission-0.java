class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = nums.length - k + 1;
        int ans[] = new int[n];
        int j=0;
        for (int i=0; i<nums.length; i++) {
            pq.add(new Pair(nums[i], i));
            if (i >= k-1) {
                while (pq.peek().b <= i-k) {
                    pq.poll();
                }
                Pair tmp = pq.peek();
                ans[j++] = tmp.a;
            }
        }
        return ans;
    }
}

class Pair implements Comparable<Pair> {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair p) {
        return p.a - this.a;
    }
}
