/* 다시풀기!! */
import java.util.*;

public class num10026{
    static int N;
    static char[][] chart;
    static boolean[][] once;
    static int[] x1 = {-1, 1, 0, 0};
    static int[] y1 = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        chart= new char[N][];
        
        for (int i = 0; i < N; i++) {
            chart[i] = sc.next().toCharArray();
        }
        sc.close();
        
        System.out.println(Count(false) + " " + Count(true));
    }
    
    static int Count(boolean Blind) {
        once = new boolean[N][N];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!once[i][j]) {
                    dfs(i, j, chart[i][j], Blind);
                    count++;
                }
            }
        }
        return count;
    }
    
    static void dfs(int x, int y, char color, boolean Blind) {
        once[x][y] = true;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + x1[d], ny = y + y1[d];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !once[nx][ny]) {
                if (( Blind && isSameColorBlind(color, chart[nx][ny])) || chart[nx][ny] == color) {
                    dfs(nx, ny, color, Blind);
                }
            }
        }
    }
    
    static boolean isSameColorBlind(char a, char b) {
        return (a == 'R' || a == 'G') && (b == 'R' || b == 'G');
    }
}
