package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*1,2,3 더하기*/
public class num9095 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];  // n은 최대 10까지
        dp[0] = 1; // 아무것도 안 더하는 경우
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 미리 dp 채우기
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
