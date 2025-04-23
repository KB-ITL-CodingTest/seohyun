/* 연결 요소의 개수 */
import java.util.*;

public class num11724{
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;

    public static void dfs(int v) {
        visited[v] = true;

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();  
        M = sc.nextInt();  

        graph = new ArrayList[N + 1];  
        visited = new boolean[N + 1];

        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
 
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

       
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;  
 
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }
}
