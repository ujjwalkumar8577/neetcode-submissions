class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int point[]: points) {
            pq.add(new Point(point));
        }
        int ans[][] = new int[k][2];
        for (int i=0; i<k; i++) {
            int tmp[] = pq.poll().getArr();
            ans[i] = tmp;
        }
        return ans;
    }
}

class Point implements Comparable<Point> {
    int x, y;

    public Point(int arr[]) {
        this.x = arr[0];
        this.y = arr[1];
    }

    @Override
    public int compareTo(Point p) {
        double dist1 = x*x + y*y;
        double dist2 = p.x*p.x + p.y*p.y;
        return (int)(dist1 - dist2);
    }

    public int[] getArr() {
        return new int[] { x, y };
    }
}
