package week9;

import java.util.*;

/*Fractions are better when continued*/
public class num32437 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    long[] fib = new long[N + 2];  // N+1 번째 항까지 필요
    fib[0] = 0;
    fib[1] = 1;

        for(int i = 2; i <= N + 1; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

        System.out.println(fib[N + 1]);  // p_N의 분자
}
}
