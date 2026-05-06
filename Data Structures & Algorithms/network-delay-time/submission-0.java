class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge> graph[] = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for (int[] time: times) {
            int s = time[0];
            int d = time[1];
            int w = time[2];
            graph[s].add(new Edge(s, d, w));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[n+1];
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.add(new Pair(k, 0));
        dis[k] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (!vis[pair.destination]) {
                vis[pair.destination] = true;
                for (int i=0; i<graph[pair.destination].size(); i++) {
                    Edge edge = graph[pair.destination].get(i);
                    if (!vis[edge.d] && dis[edge.s] + edge.w < dis[edge.d]) {
                        dis[edge.d] = dis[edge.s] + edge.w;
                        pq.add(new Pair(edge.d, dis[edge.d]));
                    }
                }
            }
        }
        int max = -1;
        for (int i=1; i<=n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, dis[i]);
        }
        return max;
    }
}

class Edge {
    int s, d, w;

    public Edge(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }
}

class Pair implements Comparable<Pair> {
    int destination;
    int distance;
    
    public Pair(int des, int dis) {
        this.destination = des;
        this.distance = dis;
    }

    @Override
    public int compareTo(Pair pair2) {
        return this.distance - pair2.distance;
    }
}
