/* 프로그래머스 -연속 부분 수열 합의 개수 */
import java.util.*;

public class numnumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        int n = sc.nextInt();
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = sc.nextInt();
        }

        Set<Integer> sumSet = new HashSet<>();
 
        int[] circle = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            circle[i] = elements[i % n];
        }
 
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += circle[start + k];
                }
                sumSet.add(sum);
            }
        }

   
        System.out.println(sumSet.size());
    }
}
