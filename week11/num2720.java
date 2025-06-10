package week11;

import java.util.Scanner;

/*세탁소 사장 동혁- 내 문제*/
public class num2720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();        // 테스트케이스 수
        while (T-- > 0) {
            int C = sc.nextInt();    // 거스름돈(센트)

            int q = C / 25;  C %= 25;   // Quarter
            int d = C / 10;  C %= 10;   // Dime
            int n = C / 5;   C %= 5;    // Nickel
            int p = C;                 // Penny

            sb.append(q).append(' ')
                    .append(d).append(' ')
                    .append(n).append(' ')
                    .append(p).append('\n');
        }
        System.out.print(sb);
        sc.close();
    }
}