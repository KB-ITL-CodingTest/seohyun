package week12;

/*세 용액*/
import java.util.*;

public class num2473 {
    static int N;
    static long[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        long minAbsSum = Long.MAX_VALUE;
        long[] result = new long[3];

        // 두 개 고정 (i, j)
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                long target = -(arr[i] + arr[j]);
                int idx = binarySearch(j + 1, N - 1, target);

                // idx 또는 idx-1 또는 idx+1 확인 (근접값 확인)
                for (int k = idx - 1; k <= idx + 1; k++) {
                    if (k <= j || k >= N) continue;
                    long sum = arr[i] + arr[j] + arr[k];
                    if (Math.abs(sum) < minAbsSum) {
                        minAbsSum = Math.abs(sum);
                        result[0] = arr[i];
                        result[1] = arr[j];
                        result[2] = arr[k];
                    }
                }
            }
        }

        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    // target에 가장 가까운 인덱스 반환
    private static int binarySearch(int left, int right, long target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
