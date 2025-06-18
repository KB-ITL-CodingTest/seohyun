package week12;

/*동혁 피자 - 구현 문제 */

import java.util.Scanner;

public class num6502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases= 1;

        while (true) {
            int r = sc.nextInt();
            if (r == 0) break;

            int w = sc.nextInt();
            int l = sc.nextInt();

            double diagonal = Math.sqrt(w * w + l * l);
            if (diagonal <= 2 * r) {
                System.out.printf("Pizza %d fits on the table.\n", cases);
            } else {
                System.out.printf("Pizza %d does not fit on the table.\n", cases);
            }
            cases++;
        }
        sc.close();
    }
}
