package week5;
/*아기상어*/
import java.util.*;
public class num17086 {

        static int N, M;
        static int[][] map;
        static int[][] dist;
        static boolean[][] visited;
        static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            M = sc.nextInt();
            map = new int[N][M];
            dist = new int[N][M];
            visited = new boolean[N][M];

            Queue<int[]> queue = new LinkedList<>();

            // 입력 받기 + 아기상어 위치 큐에 추가
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];


                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }


            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    max = Math.max(max, dist[i][j]);
                }
            }

            System.out.println(max);
        }
    }
