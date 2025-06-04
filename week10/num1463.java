package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*1로 만들기*/
public class num1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];  // dp[i] = i를 1로 만드는 최소 횟수
        dp[1] = 0;  // 1은 이미 1이므로 연산 0번

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 기본적으로 -1

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}