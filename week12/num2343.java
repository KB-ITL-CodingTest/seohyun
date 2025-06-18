package week12;

/*기타 레슨 -공통 문제*/
import java.util.*;

public class num2343 {
    static int N, M;
    static int[] lessons;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 강의 수
        M = sc.nextInt(); // 블루레이 수
        lessons = new int[N];

        int max = 0; // 최소 가능한 블루레이 크기 (한 강의의 최대값 이상)
        int sum = 0; // 모든 강의의 합 (최대 가능한 블루레이 크기)

        for (int i = 0; i < N; i++) {
            lessons[i] = sc.nextInt();
            max = Math.max(max, lessons[i]);
            sum += lessons[i];
        }

        int left = max;  // 블루레이 최소 크기
        int right = sum; // 블루레이 최대 크기
        int result = sum;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (countBluRays(mid) <= M) {
                result = mid;       // 더 작은 크기로도 가능한지 탐색
                right = mid - 1;
            } else {
                left = mid + 1;     // 너무 작아서 나눌 수 없음
            }
        }

        System.out.println(result);
    }

    // 블루레이 크기(limit)일 때 필요한 블루레이 개수 반환
    static int countBluRays(int limit) {
        int count = 1;
        int total = 0;

        for (int i = 0; i < N; i++) {
            if (total + lessons[i] > limit) {
                count++;
                total = lessons[i];
            } else {
                total += lessons[i];
            }
        }
        return count;
    }
}