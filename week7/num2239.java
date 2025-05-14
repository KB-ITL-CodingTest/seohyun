package week7;

import java.io.*;
import java.util.*;


/*스도쿠*/
public class num2239 {
    static int[][] board = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static boolean isFinished = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j) - '0';
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        dfs(0); // 백트래킹 시작
    }

    static void dfs(int depth) {
        if (depth == blanks.size()) {
            printBoard();
            isFinished = true;
            return;
        }

        int[] now = blanks.get(depth);
        int x = now[0];
        int y = now[1];

        for (int i = 1; i <= 9; i++) {
            if (isPossible(x, y, i)) {
                board[x][y] = i;
                dfs(depth + 1);
                if (isFinished) return;
                board[x][y] = 0;
            }
        }
    }

    static boolean isPossible(int x, int y, int num) {
        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num) return false;
        }

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) return false;
        }

        // 3x3 검사
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;

        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}