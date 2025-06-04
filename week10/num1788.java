package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*피보나치 수의 확장*/
/*SCanner 로 풀었지만, 계속 틀렸다고 나옴
 * - 원인을 알아볼 것!!ㅜㅜ
 * AI 의 도움 받아=> 재풀이요1!*/
public class num1788 {

    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int absN = Math.abs(n);
        int[] dp = new int[absN + 2]; // 0부터 absN까지 커버
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= absN; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        int fibN = dp[absN];

        // 부호 출력
        if (n == 0) {
            System.out.println(0);
        } else if (n > 0) {
            System.out.println(1);
        } else {
            // F(-n) = (-1)^(n+1) * F(n)
            // n < 0일 때: abs(n) % 2 == 0 → 부호 -1, 홀수 → +1
            System.out.println((absN % 2 == 0) ? -1 : 1);
        }

        System.out.println(fibN);
    }
}
