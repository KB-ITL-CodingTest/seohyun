package week10;
import java.io.*;
/*2XN 타일링*/
public class num11726 {

        static final int MOD = 10007;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 2];
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }

            System.out.println(dp[n]);
        }
    }