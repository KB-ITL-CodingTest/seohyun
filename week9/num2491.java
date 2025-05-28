package week9;

/*수열*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num2491 {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 증가/감소 dp 초기화
        int[] dp_inc = new int[N];
        int[] dp_dec = new int[N];
        Arrays.fill(dp_inc, 1);
        Arrays.fill(dp_dec, 1);

        int maxLen = 1;

        for (int i = 1; i < N; i++) {
            if (nums[i] >= nums[i - 1]) {
                dp_inc[i] = dp_inc[i - 1] + 1;
            }
            if (nums[i] <= nums[i - 1]) {
                dp_dec[i] = dp_dec[i - 1] + 1;
            }
            maxLen = Math.max(maxLen, Math.max(dp_inc[i], dp_dec[i]));
        }

        System.out.println(maxLen);
    }
}
