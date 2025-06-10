package week11;

/*센서*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class num2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());     // 센서 수
        int K = Integer.parseInt(br.readLine().trim());     // 집중국 수

        int[] pos = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pos[i] = Integer.parseInt(st.nextToken());

        // 집중국이 센서 수 이상이면 각자 담당 → 길이 0
        if (K >= N) {
            System.out.println(0);
            return;
        }

        Arrays.sort(pos);                   // 1. 위치 정렬

        int[] gap = new int[N - 1];         // 2. 간격 계산
        for (int i = 0; i < N - 1; i++) {
            gap[i] = pos[i + 1] - pos[i];
        }

        Arrays.sort(gap);                   // 3. 간격 정렬 (오름차순)

        int answer = 0;                     // 4. 가장 작은 N-K개 합산
        for (int i = 0; i < N - K; i++) {
            answer += gap[i];
        }

        System.out.println(answer);
    }
}

