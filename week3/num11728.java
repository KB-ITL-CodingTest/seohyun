/* 배열 합치기 - 내 문제*/

import java.util.*;

public class num11728{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N과 M 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[M];

        // 배열 A 입력
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // 배열 B 입력
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        // 두 배열을 합침
        int[] result = new int[N + M];
        System.arraycopy(A, 0, result, 0, N);
        System.arraycopy(B, 0, result, N, M);

        // 정렬
        Arrays.sort(result);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
