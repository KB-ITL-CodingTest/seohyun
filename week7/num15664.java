package week7;
import java.util.*;
/*N과 M (10)*/
public class num15664 {
    static int N, M;
    static int[] nums;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        result = new int[M];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums); // 사전 순 출력을 위한 정렬

        dfs(0, 0);
        System.out.print(sb);
    }

    // depth: 현재 수열의 길이, start: 비내림차순 유지용 인덱스
    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1; // 같은 depth에서 중복 숫자 방지
        for (int i = start; i < N; i++) {
            if (nums[i] == before) continue; // 같은 수는 skip
            result[depth] = nums[i];
            before = nums[i];
            dfs(depth + 1, i); // i부터 시작 → 비내림차순 유지
        }
    }
}