/* 주몽 */
import java.util.*;

public class num1940{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 재료 개수
        int M = sc.nextInt();  // 갑옷을 만드는 데 필요한 수

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
