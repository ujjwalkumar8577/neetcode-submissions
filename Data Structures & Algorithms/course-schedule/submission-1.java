class Solution {
    // Check if graph is DAG (toposort)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] prerequisite: prerequisites) {
            int s = prerequisite[0];
            int d = prerequisite[1];
            graph[s].add(d);
        }
        return !isCyclic(graph);
    }

    public boolean isCyclic(ArrayList<Integer> graph[]) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        for (int i=0; i<n; i++) {
            if (vis[i]) {
                continue;
            }
            boolean stack[] = new boolean[n];
            boolean hasCycle = isCyclicUtil(graph, vis, i, stack);
            if (hasCycle) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclicUtil(ArrayList<Integer> graph[], boolean vis[], int curr, boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;
        for (int d: graph[curr]) {
            if (stack[d]) {
                return true;
            }
            if (!vis[d] && isCyclicUtil(graph, vis, d, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
}
