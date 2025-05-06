package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*사다리 조작 */
public class num15684 {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로선
        M = Integer.parseInt(st.nextToken()); // 가로선 수
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치 수

        ladder = new boolean[H + 1][N + 1]; // 1-based 인덱스

        // 기존 가로선 정보 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 높이
            int b = Integer.parseInt(st.nextToken()); // 세로선 번호
            ladder[a][b] = true;
        }

        dfs(0, 1, 1);
        System.out.println(answer > 3 ? -1 : answer);
    }

    // 사다리를 타서 i → i 되는지 확인
    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int pos = i;
            for (int j = 1; j <= H; j++) {
                if (ladder[j][pos]) {
                    pos++;
                } else if (pos > 1 && ladder[j][pos - 1]) {
                    pos--;
                }
            }
            if (pos != i) return false;
        }
        return true;
    }

    // 가로선 추가 DFS 탐색
    public static void dfs(int count, int x, int y) {
        if (count >= answer) return;
        if (check()) {
            answer = count;
            return;
        }
        if (count == 3) return;

        for (int i = x; i <= H; i++) {
            for (int j = (i == x ? y : 1); j < N; j++) {
                if (!ladder[i][j] && !ladder[i][j - 1] && !ladder[i][j + 1]) {
                    ladder[i][j] = true;
                    dfs(count + 1, i, j + 2); // 연속된 곳엔 놓지 않도록 j+2
                    ladder[i][j] = false; // 백트래킹
                }
            }
        }
    }
}