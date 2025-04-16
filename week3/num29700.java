/* 우당탕탕 영화예매 */
import java.util.*;

public class num29700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  
        int M = sc.nextInt();  
        int K = sc.nextInt();  
        sc.nextLine();  

        int total = 0;

        for (int i = 0; i < N; i++) {
            String row = sc.nextLine();

            int count = 0;  

            for (int j = 0; j <= M; j++) {
                if (j < M && row.charAt(j) == '0') {
                    count++;
                } else {
                    if (count >= K) {
                        total += (count - K + 1);
                    }
                    count = 0;
                }
            }
        }

        System.out.println(total);
    }
}