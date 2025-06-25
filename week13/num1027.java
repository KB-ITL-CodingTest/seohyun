package week13;

/*고층 건물*/
import java.util.*;

public class num1027  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 건물 수
        int[] height = new int[N];

        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }

        int maxVisible = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                boolean canSee = true;

                double slope = (double)(height[j] - height[i]) / (j - i);

                for (int k = Math.min(i, j) + 1; k < Math.max(i, j); k++) {
                    double expected = height[i] + slope * (k - i);

                    if (height[k] >= expected) {
                        canSee = false;
                        break;
                    }
                }

                if (canSee) count++;
            }

            maxVisible = Math.max(maxVisible, count);
        }

        System.out.println(maxVisible);
    }
}
