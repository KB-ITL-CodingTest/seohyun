package week12;

/*예산- 내 문제*/
import java.util.*;

public class num2512{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 지방의 수
        int[] requests = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            requests[i] = sc.nextInt();
            max = Math.max(max, requests[i]);
        }

        int M = sc.nextInt(); // 총 예산

        int left = 0;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long total = 0;
            for (int r : requests) {
                total += Math.min(r, mid);
            }

            if (total <= M) {
                answer = mid; // 가능한 상한값
                left = mid + 1; // 더 큰 상한도 가능한지 탐색
            } else {
                right = mid - 1; // 예산 초과 → 상한 낮춰야 함
            }
        }

        System.out.println(answer);
    }
}