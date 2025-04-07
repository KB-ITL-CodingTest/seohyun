/* 스택 수열-공통 문제  */

import java.util.*;

public class num1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수열의 길이

        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int current = 1; // 다음 push할 숫자
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int num = sequence[i];

            // push가 필요한 경우
            while (current <= num) {
                stack.push(current++);
                sb.append("+\n");
            }

            // pop해서 꺼낸 숫자가 일치하는지 확인
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
