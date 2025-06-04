package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*거스름돈 - 내 문제
* */
public class num14916 {
    static final int INF = 100_001;  // n 최대가 100,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        // 초기화
        for (int i = 1; i <= n; i++) {
            dp[i] = INF;
        }

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i >= 2 && dp[i - 2] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (i >= 5 && dp[i - 5] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }
}



/*그리디+ 반복
* import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n >= 0) {
            if (n % 5 == 0) {
                count += n / 5;
                System.out.println(count);
                return;
            }
            n -= 2; // 5원짜리 못 쓰면 2원짜리 하나 씀
            count++;
        }

        System.out.println(-1); // 거슬러 줄 수 없음
    }
}
 */