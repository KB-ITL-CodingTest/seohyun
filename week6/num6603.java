package week6;

import java.util.Scanner;

/*로또- 내 문제*/
/*1.
* 2.
* 3.
* 0을 누르면 입력받는 것을 종료시킬 수 있도록
* 출력할 때눈 사전순으로, 케이스 사이에는 빈 줄 하나씩 출력한다. */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class num6603 {
    static int[] nums;
    static int[] selected = new int[6];
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);

            if (k == 0) break;

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(input[i + 1]);
            }

            // 조합 시작
            dfs(0, 0, sb);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // depth: 현재까지 선택한 숫자 개수
    // start: nums에서 탐색을 시작할 인덱스
    static void dfs(int depth, int start, StringBuilder sb) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            selected[depth] = nums[i];
            dfs(depth + 1, i + 1, sb);
        }
    }
}

