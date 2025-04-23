/* 점프왕 젤리 */
import java.util.Scanner;

public class num16173{
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static boolean canReach = false;

 
    static int[] dx = {0, 1}; 
    static int[] dy = {1, 0};

    public static void dfs(int x, int y) {
        if (canReach) return;  

        int jump = board[x][y];
        if (jump == -1) {
            canReach = true;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * jump;
            int ny = y + dy[i] * jump;

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

        visited[0][0] = true;
        dfs(0, 0);

        System.out.println(canReach ? "HaruHaru" : "Hing");
    }
}
