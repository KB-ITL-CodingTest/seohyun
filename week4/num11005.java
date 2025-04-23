/* 구현문제 -진법 변환2 -> 제일 못하는거 */

import java.util.Scanner;

public class num11005{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  
        int B = sc.nextInt();  

        StringBuilder result = new StringBuilder();

        while (N > 0) {
            int remainder = N % B;

           
            if (remainder < 10) {
                result.append((char) (remainder + '0'));
            } else {
                result.append((char) (remainder - 10 + 'A'));
            }

            N /= B;
        }
 
        System.out.println(result.reverse().toString());
    }
}
