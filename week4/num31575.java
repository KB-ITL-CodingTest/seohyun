/* 도시와 비트코인 -> 어려움*/
import java.util.Scanner;

public class num31575 {
    static int N, M;
    static int[][] city;
    static boolean[][] visited;
    static boolean canReach = false;


    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void dfs(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            canReach = true;
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

      
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (city[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();  
        M = sc.nextInt();  
        city = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);


        System.out.println(canReach ? "Yes" : "No");
    }
}
