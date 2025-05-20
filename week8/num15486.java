package week8;
/*퇴사2*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class num15486{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        long[] dp = new long[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N + 1; i++) {

            dp[i] = Math.max(dp[i], dp[i - 1]);


            int next = i + T[i];
            if (next <= N + 1) {
                dp[next] = Math.max(dp[next], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}
