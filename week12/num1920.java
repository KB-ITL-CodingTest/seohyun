package week12;

/*수 찾기 - 공통 문제*/
import java.util.*;

public class num1920{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();               // A 배열 크기
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();            // A 배열 입력
        }

        Arrays.sort(A);                     // 이진 탐색을 위해 정렬

        int M = sc.nextInt();               // 찾을 숫자 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            if (binarySearch(A, target)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb.toString());
    }

    // 이진 탐색 함수
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;                // 찾음
            } else if (arr[mid] < target) {
                left = mid + 1;             // 오른쪽으로 이동
            } else {
                right = mid - 1;            // 왼쪽으로 이동
            }
        }

        return false;                       // 없음
    }
}