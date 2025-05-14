package week7;

/*색종이 붙이기
*++ 혼자서 절대 못 품
*접근 방법 알아두자!!
*
* 여러 개의 크기의 정사각형을 1인 구역을 어떻게 채울지
*
*  */

import java.util.Scanner;

public class num17136 {
    static int[][] board = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5}; // 색종이 1~5 크기별 개수
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0, 0); // 시작 좌표 (0,0), 사용 색종이 수 0

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int x, int y, int used) {
        if (x >= 9 && y > 9) {
            min = Math.min(min, used);
            return;
        }

        if (min <= used) return;

        if (y > 9) {
            dfs(x + 1, 0, used);
            return;
        }

        if (board[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (paper[size] > 0 && isAttachable(x, y, size)) {
                    attachPaper(x, y, size, 0);
                    paper[size]--;
                    dfs(x, y + 1, used + 1);
                    attachPaper(x, y, size, 1); // 복구
                    paper[size]++;
                }
            }
        } else {
            dfs(x, y + 1, used);
        }
    }

    static boolean isAttachable(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }

    static void attachPaper(int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = value;
            }
        }
    }
}