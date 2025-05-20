package week8;

/*구현 문제 - 피보나치 수*/

import java.util.Scanner;

public class num2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] fib = new int[n + 1];

        // 기본값 초기화
        fib[0] = 0;
        if (n >= 1) {
            fib[1] = 1;
        }

        // 피보나치   수 계산
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        System.out.println(fib[n]); // 결과 출력
    }
}
