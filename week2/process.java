/* process - 큐 */
import java.util.*;

public class process{
    public static int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int prev = -1; // 배열 원소는 0~9이므로 초기값을 -1로 설정

        for (int num : arr) {
            if (num != prev) {
                result.add(num);
                prev = num;
            }
        }

        // List<Integer>를 int[]로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    // 테스트용 main 함수
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};

        System.out.println(Arrays.toString(solution(arr1))); // [1, 3, 0, 1]
        System.out.println(Arrays.toString(solution(arr2))); // [4, 3]
    }
}
