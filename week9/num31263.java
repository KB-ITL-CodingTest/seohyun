package week9;/*대한민국을 지키는 가장 긴 힘*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class num31263 {
    static final int MAX = 641;
    static final int INF = 5001;  // N의 최대 + 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) dp[i] = INF;
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] == INF) continue;

            for (int len = 1; len <= 3; len++) {
                if (i + len > N) break;

                String part = S.substring(i, i + len);

                if (part.charAt(0) == '0') continue; // 앞에 0이 오면 안 됨

                int num = Integer.parseInt(part);
                if (num >= 1 && num <= MAX) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
                }
            }
        }

        System.out.println(dp[N]);
    }
}