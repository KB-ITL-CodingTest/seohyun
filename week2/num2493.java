/* 탑 문제-스택 */
import java.util.*;
import java.io.*;

/* public class num2493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 탑의 개수
        int[] heights = new int[N]; // 탑 높이 배열
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        int[] result = new int[N]; // 결과 저장 배열
        Stack<int[]> stack = new Stack<>(); // 스택에는 [인덱스, 높이] 저장

        for (int i = 0; i < N; i++) {
            int height = heights[i];

            // 스택에서 현재 탑보다 낮은 탑은 제거
            while (!stack.isEmpty() && stack.peek()[1] < height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[0] + 1; // 수신한 탑의 번호 (1-based)
            } else {
                result[i] = 0;
            }

            stack.push(new int[]{i, height});
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
} 스캐너로 하면!! 메모리 초과 */



public class num2493{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력
        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() + 1; // 인덱스 → 번호 변환
            } else {
                result[i] = 0;
            }

            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}

