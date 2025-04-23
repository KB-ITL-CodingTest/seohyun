/* 주몽 */
import java.util.*;

public class num1940{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   
        int M = sc.nextInt();   

        int[] materials = new int[N];

        for (int i = 0; i < N; i++) {
            materials[i] = sc.nextInt();
        }

        // 정렬
        Arrays.sort(materials);

        int count = 0;
        int start = 0;
        int end = N - 1;

        while (start < end) {
            int sum = materials[start] + materials[end];

            if (sum == M) {
                count++;
                start++;
                end--;
            } else if (sum < M) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);
    }
}
