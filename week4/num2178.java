/* 미로 탐색 */
import java.util.*;

public class num2178 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

 
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
 
                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[ny][nx] && maze[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        maze[ny][nx] = maze[y][x] + 1;  
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  
        M = sc.nextInt();  

        maze = new int[N][M];
        visited = new boolean[N][M];

      
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
 
        System.out.println(maze[N - 1][M - 1]);
    }
}
