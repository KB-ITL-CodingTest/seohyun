import java.util.*;

class programmersdfs {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count;

    public int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

      
        for (int i = 0; i < wires.length; i++) {
            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

        
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; 
                int v1 = wires[j][0];
                int v2 = wires[j][1];
                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            visited = new boolean[n + 1];
            count = 0;

            dfs(1); 

            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    // DFS로 노드 개수 세기
    public void dfs(int node) {
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
