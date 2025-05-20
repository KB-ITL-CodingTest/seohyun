package week8;
/*설탕 배달*/
import java.util.Scanner;
import java.util.Arrays;

public class num2839{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 5001);
        dp[0] = 0;

        for (int i = 3; i <= N; i++) {
            if (i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if (i >= 5) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        System.out.println(dp[N] == 5001 ? -1 : dp[N]);
    }
}
