package week11;

/*햄버거 분배*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class num19941{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray(); // 길이 N

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] != 'P') continue;          // 사람이 아니면 skip

            int left = Math.max(0, i - K);
            int right = Math.min(N - 1, i + K);

            for (int j = left; j <= right; j++) {
                if (arr[j] == 'H') {              // 먹을 수 있는 햄버거 찾음
                    arr[j] = '.';                 // 사용 처리
                    result++;
                    break;                        // 이 사람은 먹었으니 끝
                }
            }
        }

        System.out.println(result);
    }
}
