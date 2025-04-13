/* 수들의 합 5 */
import java.util.Scanner;

public class num2018{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (start <= N) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else { // sum == N
                count++;
                sum -= start;
                start++;
            }
        }

        System.out.println(count);
    }
}
