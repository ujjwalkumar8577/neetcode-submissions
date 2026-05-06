class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        boolean hasCycle = isCyclicUtil(graph, vis, 0, -1);
        if (hasCycle) {
            return false;
        }

        for (boolean e: vis) {
            if (!e) {
                return false;
            }
        }
        
        return true;
    }

    public boolean isCyclicUtil(ArrayList<Integer> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int d: graph[curr]) {
            if (!vis[d]) {
                boolean hasCycle = isCyclicUtil(graph, vis, d, curr);
                if (hasCycle) {
                    return true;
                }
            } else if (d != par) {
                return true;
            }
        }
        return false;
    }
}
