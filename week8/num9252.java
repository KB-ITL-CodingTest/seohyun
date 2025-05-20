package week8;
/*LCS2*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class num9252 {
    static String str1, str2;
    static int[][] dp;
    static StringBuilder lcs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine();
        str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();
        dp = new int[len1 + 1][len2 + 1];


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // LCS 길이 출력
        System.out.println(dp[len1][len2]);

        // LCS 문자열 역추적
        backtrack(len1, len2);

        if (lcs.length() > 0) {
            System.out.println(lcs.reverse()); // 역순으로 구했기 때문에 reverse
        }
    }

    // DP 테이블을 이용한 역추적 함수
    private static void backtrack(int i, int j) {
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
    }
}
