/* 2399번 -거리의 합(구현 문제) */

import java.util.*;

public class num2399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] x = new long[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
        }

        Arrays.sort(x);

        // 누적합 계산
        long[] Sum = new long[n];
        Sum[0] = x[0];
        for (int i = 1; i < n; i++) {
            Sum[i] = Sum[i - 1] + x[i];
        }

        long total = 0;

        for (int i = 1; i < n; i++) {
            total += x[i] * i - Sum[i - 1];
        }

        System.out.println(total * 2); // 양방향 쌍이므로 *2
    }
}