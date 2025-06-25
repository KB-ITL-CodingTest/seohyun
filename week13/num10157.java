package week13;

/*자리배정*/
import java.util.*;

public class num10157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int R = sc.nextInt();
        int K = sc.nextInt();
        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int[][] seat = new int[R][C];

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int x = 0, y = R - 1, dir = 0, count = 1;

        while (true) {
            seat[y][x] = count;

            if (count == K) {
                System.out.println((x + 1) + " " + (R - y));
                break;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];


            if (nx >= 0 && nx < C && ny >= 0 && ny < R && seat[ny][nx] == 0) {
                x = nx;
                y = ny;
                count++;
            } else {

                dir = (dir + 1) % 4;
            }
        }
    }
}
