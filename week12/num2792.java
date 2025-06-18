package week12;
/*보석 상자 - 공통 문제*/

import java.util.*;

public class num2792 {
    static int N, M;
    static int[] gems;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 학생 수
        M = sc.nextInt(); // 색상 수

        gems = new int[M];
        int max = 0;

        for (int i = 0; i < M; i++) {
            gems[i] = sc.nextInt();
            max = Math.max(max, gems[i]); // 이분 탐색의 최대값
        }

        int left = 1;
        int right = max;
        int result = max;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDivide(mid)) {
                result = mid;     // 현재 질투심으로도 분배 가능 → 더 줄여보기
                right = mid - 1;
            } else {
                left = mid + 1;   // 너무 작아서 불가능 → 늘려야 함
            }
        }

        System.out.println(result);
    }

    // 주어진 질투심(maxPerStudent)으로 모든 보석을 나눌 수 있는가?
    private static boolean canDivide(int maxPerStudent) {
        long count = 0; // 필요한 학생 수

        for (int g : gems) {
            count += (g + maxPerStudent - 1) / maxPerStudent; // 올림 계산
        }

        return count <= N;
    }
}
