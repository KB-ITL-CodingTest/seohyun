/* num 7576 풀기 */
import java.util.*;

public class num7576{
    static int M, N;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();  
        N = sc.nextInt();  
        box = new int[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        int unripeCount = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else if (box[i][j] == 0) {
                    unripeCount++;
                }
            }
        }
        sc.close();
        
        System.out.println(bfs(queue, unripeCount));
    }
    
    static int bfs(Queue<int[]> queue, int unripeCount) {
        if (unripeCount == 0) return 0; // 모든 토마토가 이미 익음
        
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];
                
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                        unripeCount--;
                    }
                }
            }
        }
        
        return unripeCount == 0 ? days - 1 : -1; // 모든 토마토가 익었으면 days-1, 아니면 -1
    }
}