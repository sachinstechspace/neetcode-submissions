class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        boolean[][] graph = new boolean[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("Round " + count);
                dfs(n, i, visited, graph);
                count++;
            }
        }
        return count;
    }

    public void dfs(int n, int node, boolean[] visited, boolean[][] graph) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        System.out.println("Visited node " + node);
        for(int i = 0; i < n; i++) {
            if (graph[node][i] && !visited[i]) {
                dfs(n, i, visited, graph);
            }
        }
    }
}
