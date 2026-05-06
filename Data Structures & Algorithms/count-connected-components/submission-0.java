class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i=0; i<n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge: edges) {
            int s = edge[0];
            int d = edge[1];
            graph[s].add(d);
            graph[d].add(s);
        }
        boolean vis[] = new boolean[n];
        for (int i=0; i<n; i++) {
            if (!vis[i]) {
                bfs(graph, vis, i);
                count++;
            }
        }
        return count;
    }

    public void bfs(ArrayList<Integer> graph[], boolean vis[], int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (vis[curr]) {
                continue;
            }
            vis[curr] = true;
            for (int neighbor: graph[curr]) {
                q.add(neighbor);
            }
        }
    }
}
