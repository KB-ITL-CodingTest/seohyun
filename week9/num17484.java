package week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*진우의 달 여행*/
public class num17484 {
    static int[][] map;
    static int[][][] dp; // dp[y][x][dir]
    static int N, M;
    static int[] dy = {1, 1, 1}; // 아래로만 이동
    static int[] dx = {-1, 0, 1}; // 좌하, 하, 우하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        // 첫 줄 초기화
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                dp[0][j][d] = map[0][j];
            }
        }

        // DP 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    int prevX = j - dx[d];
                    if (prevX < 0 || prevX >= M) continue;

                    for (int prevD = 0; prevD < 3; prevD++) {
                        if (prevD == d) continue;
                        if (dp[i - 1][prevX][prevD] != Integer.MAX_VALUE) {
                            dp[i][j][d] = Math.min(dp[i][j][d],
                                    dp[i - 1][prevX][prevD] + map[i][j]);
                        }
                    }
                }
            }
        }

        // 마지막 줄에서 최소값 구하기
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                result = Math.min(result, dp[N - 1][j][d]);
            }
        }

        System.out.println(result);
    }
}