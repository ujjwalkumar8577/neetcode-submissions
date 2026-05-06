class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] prerequisite: prerequisites) {
            int s = prerequisite[0];
            int d = prerequisite[1];
            graph[s].add(d);
        }
        if (isCyclic(graph)) {
            return new int[0];
        }
        ArrayList<Integer> list = topoSort(graph);
        return list.stream().mapToInt(i -> i).toArray();
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

    public ArrayList<Integer> topoSort(ArrayList<Integer> graph[]) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            if (vis[i]) {
                continue;
            }
            topoSortUtil(graph, vis, i, stack);
        }
        return new ArrayList<>(stack);
    }

    public void topoSortUtil(ArrayList<Integer> graph[], boolean vis[], int curr, Stack<Integer> stack) {
        vis[curr] = true;
        for (int d: graph[curr]) {
            if (!vis[d]) {
                topoSortUtil(graph, vis, d, stack);
            }
        }
        stack.push(curr);
    }
}
