/* 유기농 배추 */
import java.util.*;

public class num1012 {
    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};  
    static int[] dy = {-1, 1, 0, 0};

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (field[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        for (int t = 0; t < T; t++) {
            M = sc.nextInt();  
            N = sc.nextInt();  
            K = sc.nextInt();  

            field = new int[N][M];
            visited = new boolean[N][M];

            
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1;
            }

            int wormCount = 0;
 
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (field[y][x] == 1 && !visited[y][x]) {
                        bfs(x, y);
                        wormCount++;  
                    }
                }
            }

            System.out.println(wormCount);
        }
    }
}
