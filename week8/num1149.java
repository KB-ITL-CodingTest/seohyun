package week8;
/*RGB*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class num1149{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 집의 수
        int[][] cost = new int[N][3]; // 입력 비용 저장
        int[][] dp = new int[N][3];   // DP 테이블

        // 비용 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); // 빨강
            cost[i][1] = Integer.parseInt(st.nextToken()); // 초록
            cost[i][2] = Integer.parseInt(st.nextToken()); // 파랑
        }

        // 첫 번째 집은 그대로 저장
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // 두 번째 집부터 DP 계산
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]; // 빨강
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]; // 초록
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]; // 파랑
        }

        // 마지막 집에서 최소 비용 출력
        int result = Math.min(dp[N - 1][0],
                Math.min(dp[N - 1][1], dp[N - 1][2]));
        System.out.println(result);
    }
}
