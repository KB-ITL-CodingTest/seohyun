package week9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*할 일 정하기1*/
public class num1311 {
    static int N;
    static int[][] cost;
    static int[] dp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size = 1 << N;  // 총 가능한 상태 수 (2^N)
        dp = new int[size];
        Arrays.fill(dp, INF);
        dp[0] = 0;  // 초기 상태: 아무 일도 하지 않았을 때 비용은 0

        for (int bit = 0; bit < size; bit++) {
            int person = Integer.bitCount(bit); // 지금까지 일 맡은 사람 수
            if (person >= N) continue;

            for (int j = 0; j < N; j++) {
                if ((bit & (1 << j)) == 0) { // j번째 일이 비어있다면
                    int next = bit | (1 << j);
                    dp[next] = Math.min(dp[next], dp[bit] + cost[person][j]);
                }
            }
        }

        System.out.println(dp[size - 1]); // 모든 일이 배정된 상태
    }
}